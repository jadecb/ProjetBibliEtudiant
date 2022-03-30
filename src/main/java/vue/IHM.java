package vue;

import modele.*;
import util.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;

import static java.time.LocalDate.now;

/**
 * La classe IHM est responsable des interactions avec l'utilisateur/trice en
 * mode texte. C'est une classe qui n'est associée à aucun état : elle ne
 * contient aucun attribut d'instance. Aucune méthode de cette classe n'est pas
 * censée modifier ses paramètres, c'est pourquoi les paramètres des méthodes
 * sont tous marqués comme `final`.
 */
public class IHM {

    private final Bibliotheque bibliotheque;

    public IHM(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

//-----  affichage menu et saisie des commandes par l'utilisateur  -------------------------------------------------
    /**
     * afficherInterface permet l'affichage du menu et le choix d'une commande
     * par l'utilisateur (dialogueSaisirCommande) puis l'invocation de la
     * méthode de la classe Bibliotheque réalisant l'action (gererDialogue)
     */
    public void afficherInterface() {
        Commande cmd;
        do {
            cmd = this.dialogueSaisirCommande();
            this.gererDialogue(cmd);
        } while (cmd != Commande.QUITTER);
    }

    private Commande dialogueSaisirCommande() {
        ES.afficherTitre("===== Bibliotheque =====");
        ES.afficherLibelle(Commande.synopsisCommandes());
        ES.afficherLibelle("===============================================");
        ES.afficherLibelle("Saisir l'identifiant de l'action choisie :");
        return Commande.lireCommande();
    }

    private void gererDialogue(Commande cmd) {
        switch (cmd) {
            case QUITTER:
                break;
            case CREER_LECTEUR:
                bibliotheque.nouveauLecteur(this);
                break;
            case CONSULTER_LECTEURS:
                bibliotheque.consulterLecteur(this);
                break;
            case CREER_OUVRAGE:
                bibliotheque.nouvelOuvrage(this);
                break;
            case AFFICHER_OUVRAGE:
                bibliotheque.ConsulterOuvrage(this);
                break;
            case CREER_EXEMPLAIRE:
                bibliotheque.NouvelExemplaire(this);
                break;
            case AFFICHER_EXEMPLAIRE:
                bibliotheque.ConsulterExemplairesOuvrage(this);
                break;
            case EMPRUNTER_EXEMPLAIRE:
                bibliotheque.emprunterExemplaire(this);
                break;
            case RENDRE_EXEMPLAIRE:
                bibliotheque.rendreExemplaire(this);
                break;
            case CONSULTER_EMPRUNT_LECTEUR:
                bibliotheque.consulterEmpruntsLecteur(this);
                break;
            case RELANCER_LECTEUR:
                bibliotheque.relancerLecteur(this);
                break;
            default:
                assert false : "Commande inconnue.";
        }
    }

//-----  Classes conteneurs et éléments de dialogue pour le lecteur -------------------------------------------------
    /**
     * Classe conteneur pour les informations saisies pour la création d'un
     * lecteur. Tous les attributs sont `public` par commodité d'accès. Tous les
     * attributs sont `final` pour ne pas être modifiables.
     */
    public static class InfosLecteur {

        public final String nom;
        public final String prenom;
        public final String adresse;
        public final LocalDate dateNaiss;
        public final String email;

        public InfosLecteur( final String nom, final String prenom, final String adresse, final LocalDate dateNaiss, final String email) {
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.dateNaiss = dateNaiss;
            this.email = email;
        }
    }

    public InfosLecteur saisirLecteur() {
        String nom, prenom, adresse, email;
        LocalDate dateNaiss;

        ES.afficherTitre("== Saisie d'un lecteur ==");
        nom = ES.lireChaine("Saisir le nom du lecteur :");
        prenom = ES.lireChaine("Saisir le prénom du lecteur :");
        adresse = ES.lireChaine("Saisir l'adresse du lecteur :");
        email = ES.lireEmail("Saisir l'email du lecteur :");
        dateNaiss = ES.lireDate("- Date de naissance : ");

        while(dateNaiss.isAfter(now()))
        {
            dateNaiss = ES.lireDate("La date de naissance doit être antérieure à la date du jour.\n- Entrer une nouvelle date : ");
        }
        return new InfosLecteur(nom, prenom, adresse, dateNaiss, email);
    }

    public void afficherLecteur(Lecteur lecteur) {
        ES.afficherTitre("== affichage du lecteur== " + lecteur.getNum());
        ES.afficherLibelle("nom, prénom et mail du lecteur :" + lecteur.getNom() + " " + lecteur.getPrenom() + " " + lecteur.getEmail());
        ES.afficherLibelle("date de naissance et age du lecteur :" + lecteur.getDateNaiss() + " " + lecteur.getAge());
    }
    public Set<Integer> NumsLecteurs;

    public boolean verifNumLecteur(int numLecteur) {

        if (NumsLecteurs.contains(numLecteur)) {
            return true;
        } else {
            return false;
        }

    }

    public int saisirNumLecteur(Set<Integer> NumsLecteur) {
        this.NumsLecteurs = NumsLecteur;
        ES.afficherLibelle("Saisir le numero du lecteur");
        int numLecteur = ES.lireEntier();
        boolean a = verifNumLecteur(numLecteur);

        while (!a) {

            ES.afficherLibelle("Veuiller renseigner un numero de lecteur existant");
            numLecteur = ES.lireEntier();
            a = verifNumLecteur(numLecteur);
        }

        return numLecteur;
    }






//-----  Classes conteneurs et éléments de dialogue pour l'ouvrage -------------------------------------------------
    /**
     * Classe conteneur pour les informations saisies pour la création d'un
     * ouvrage. Tous les attributs sont `public` par commodité d'accès. Tous les
     * attributs sont `final` pour ne pas être modifiables.
     */
    public static class InfosOuvrage {

        public final String isbn;
        public final String titre;
        public final String Auteur;
        public final String nomEditeur;
        public final LocalDate dateParution;
        public int dernierNumExemplaire;
        public Public typePublic;

        public InfosOuvrage(final String isbn, final String titre, final String Auteur, final String nomEditeur, final LocalDate dateParution, int dernierNumExemplaire, Public typePublic) {
            this.isbn = isbn;
            this.titre = titre;
            this.Auteur = Auteur;
            this.nomEditeur = nomEditeur;
            this.dateParution = dateParution;
            this.dernierNumExemplaire = dernierNumExemplaire;
            this.typePublic = typePublic;
        }

    }

    public InfosOuvrage saisirOuvrage() {
        String titre, nomEditeur;
        LocalDate DateParution;
        ArrayList<String> auteurs = new ArrayList<String>();
        Public typePublic = null;
        Boolean test = true;
        int TPublic = 0;
        Scanner sc= new Scanner(System.in);

        ES.afficherTitre("== Saisie d'un ouvrage ==");
        titre = ES.lireChaine("Saisir le titre de l'ouvrage:");
        nomEditeur = ES.lireChaine("Saisir l'éditeur de l'ouvrage :");
        DateParution = ES.lireDate("Saisir la date de parution de l'ouvrage :");

        while(DateParution.isAfter(now()))
        {
            DateParution = ES.lireDate("La date de parution doit être antérieur à la date du jour.\n- Veuillez entrer une nouvelle date : ");
        }
        nomEditeur = ES.lireChaine("- Nom de l'éditeur : ");

        while(test == true)
        {
            auteurs.add(ES.lireChaine("Saisir l'auteur de l'ouvrage :"));
            test = ES.lireBoolean("Souhaitez-vous ajouter un auteur ?");
        }

        test = true;
        ES.afficherLibelle("Entrer 1 pour adulte, 2 pour ado, 3 pour enfant");

        while(test == true)
        {
            TPublic = sc.nextInt();
            if(TPublic != 1 && TPublic != 2 && TPublic != 3)
            {
                ES.afficherLibelle("Le numéro doit être 1, 2 ou 3.\n- Entrer un nouveau numéro : ");
            }
            else
            {
                test = false;
            }
        }

        switch (TPublic)
        {
            case 1:
                typePublic = Public.ADULTE;
                break;
            case 2:
                typePublic = Public.ADO;
                break;
            case 3:
                typePublic = Public.ENFANT;
                break;
        }

        InfosOuvrage infosOuvrage = new InfosOuvrage(titre, nomEditeur, auteurs,dateParution, typePublic);

        return infosOuvrage;
    }

    public void afficherOuvrage(final String isbn, final String titre, final String Auteur, final String nomEditeur,
                                final Date dateParution) {
        ES.afficherTitre("== affichage de l'ouvrage == " + isbn);
        ES.afficherLibelle("isbn, titre, nom de l'éditeur et date de parution :" + isbn + " " + titre + " " + Auteur + " " + nomEditeur + " " + dateParution);

    }

    public String saisirIsbn(Set<String> isbn) {
        String isbnsaisie;
        ES.afficherTitre("== Consultation d'un ouvrage ==");
        isbnsaisie = ES.lireChaine("Veuillez saisir ibsn de l'ouvrage");
//        recuperer la liste isbn
        String isbnverif;
        isbnverif = estDansList(isbnsaisie,isbn);

        return isbnverif;
    }

    public String estDansList(String isbnsaisie, Set<String> isbn ){
        while (isbn.contains(isbnsaisie)){
            isbnsaisie = ES.lireChaine("Veuillez saisir ibsn de l'ouvrage");
        }

        return isbnsaisie;
    }

    //-----  Classes conteneurs et éléments de dialogue pour l'exemplaire --------------//
    public static class InfosExemplaire {

        public final LocalDate dateRecepExemp;
        public final Integer nbExemplaire;
        public final Integer nbeEmpruntable;
        public final String isbnSaisie;

        public InfosExemplaire(final LocalDate dateRecepExemp, final Integer nbExemplaire, final Integer nbeEmpruntable, final String isbnSaisie) {
            this.dateRecepExemp = dateRecepExemp;
            this.nbExemplaire = nbExemplaire;
            this.nbeEmpruntable = nbeEmpruntable;
            this.isbnSaisie = isbnSaisie;
        }
    }

    public InfosExemplaire saisirExemplaire() {
        LocalDate dateRecepExemp;
        String isbnSaisie;
        Integer nbExemplaire, nbeEmpruntable;

        ES.afficherTitre("== Saisie des informations des exemplaires d'un ouvrage ==");
        dateRecepExemp = ES.lireDate("Saisir la date de réception");
        nbExemplaire = ES.lireEntier("Saisir le nombre d'exemplaire total");
        nbeEmpruntable = ES.lireEntier("Saisir le nombre d'exemplaires empruntables");
        isbnSaisie = ES.lireChaine("Saisir l'ISBN de l'ouvrage");

        LocalDate dateduJour = now();

        if (dateRecepExemp.isBefore(dateduJour)) {
            informerUtilisateur("date de parution incorrect. Veuillez resaisir");
        }
        if (nbeEmpruntable > nbExemplaire) {
            informerUtilisateur("nombre d'exemplaires empruntables incorrects.Veuillez resaisir le bon nombre.");
        }

        return new InfosExemplaire(dateRecepExemp, nbExemplaire, nbeEmpruntable, isbnSaisie);
    }



//-----  Primitives d'affichage  -----------------------------------------------

    public void informerUtilisateur(final String msg, final boolean succes) {
        ES.afficherLibelle((succes ? "[OK]" : "[KO]") + " " + msg);
    }

    public void informerUtilisateur(final String msg) {
        ES.afficherLibelle(msg);
    }

}
