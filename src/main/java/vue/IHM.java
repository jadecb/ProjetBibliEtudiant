package vue;

import modele.*;
import util.*;

import java.util.Date;
import java.util.Set;
import java.time.LocalDate;

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
                ES.afficherLibelle("non développé");
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

        public final Integer num;
        public final String nom;
        public final String prenom;
        public final String adresse;
        public final LocalDate dateNaiss;
        public final String email;

        public InfosLecteur(final Integer num, final String nom, final String prenom, final String adresse, final LocalDate dateNaiss, final String email) {
            this.num = num;
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
        Integer num;

        ES.afficherTitre("== Saisie d'un lecteur ==");
        num = ES.lireEntier("Saisir le numéro du lecteur :");
        nom = ES.lireChaine("Saisir le nom du lecteur :");
        prenom = ES.lireChaine("Saisir le prénom du lecteur :");
        adresse = ES.lireChaine("Saisir l'adresse du lecteur :");
        dateNaiss = ES.lireDate("Saisir la date de naissance du lecteur :");
        email = ES.lireEmail("Saisir l'email du lecteur :");

        return new InfosLecteur(num, nom, prenom, adresse, dateNaiss, email);
    }

    public void afficherLecteur(final Integer num, final String nom, final String prenom,
                                final LocalDate dateNaiss, final int age, final String email) {
        ES.afficherTitre("== affichage du lecteur== " + num);
        ES.afficherLibelle("nom, prénom et mail du lecteur :" + nom + " " + prenom + " " + email);
        ES.afficherLibelle("date de naissance et age du lecteur :" + dateNaiss + " " + age);
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

        public InfosOuvrage(final String isbn, final String titre, final String Auteur, final String nomEditeur, final LocalDate dateParution) {
            this.isbn = isbn;
            this.titre = titre;
            this.Auteur = Auteur;
            this.nomEditeur = nomEditeur;
            this.dateParution = dateParution;
        }

    }

    public InfosOuvrage saisirOuvrage() {
        String titre, Auteur, nomEditeur;
        LocalDate dateParution;
        String isbn;

        ES.afficherTitre("== Saisie d'un ouvrage ==");
        isbn = ES.lireChaine("Saisir l'ISBN de l'ouvrage :");
        titre = ES.lireChaine("Saisir le titre de l'ouvrage:");
        Auteur = ES.lireChaine("Saisir le nom de l'auteur");
        nomEditeur = ES.lireChaine("Saisir l'éditeur de l'ouvrage :");
        dateParution = ES.lireDate("Saisir la date de parution de l'ouvrage :");

        return new InfosOuvrage(isbn, titre, Auteur, nomEditeur, dateParution);
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
//-----  Primitives d'affichage  -----------------------------------------------

    public void informerUtilisateur(final String msg, final boolean succes) {
        ES.afficherLibelle((succes ? "[OK]" : "[KO]") + " " + msg);
    }

    public void informerUtilisateur(final String msg) {
        ES.afficherLibelle(msg);
    }

}
