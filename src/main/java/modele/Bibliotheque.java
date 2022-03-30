package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


import vue.IHM;


public class Bibliotheque implements Serializable {

    private static final long serialVersionUID = 1L;  // nécessaire pour la sérialisation
    private Map<Integer, Lecteur> lecteurs;
    private Map<String, Ouvrage> ouvrages;
    private int dernnumlect = 1;
    private LocalDate Date;

    public Bibliotheque() {
        this.dernnumlect = 1;
        this.lecteurs = new HashMap<>();
        this.ouvrages = new HashMap<>();
    }

    //-----  méthodes concernant la classe lecteur -------------

    public void nouveauLecteur(IHM ihm) {
        int numLecteur = IncrementerNumLecteur();
        IHM.InfosLecteur infosLecteur = ihm.saisirLecteur();
        Lecteur l = lecteurs.get(numLecteur);
        if (l == null) {
            l = new Lecteur(numLecteur, infosLecteur.nom, infosLecteur.prenom,infosLecteur.dateNaiss,infosLecteur.email);
            ihm.informerUtilisateur("création du lecteur de numéro : " + numLecteur, true);

        } else {
            ihm.informerUtilisateur("numéro de lecteur existant", false);
        }
    }
    private Collection<Lecteur> lecteurs() {
        return lecteurs.values();
    }

    public void consulterLecteur(IHM ihm) {
        int numlecteur = ihm.saisirNumLecteur(listeNumLec());
        Lecteur l = lecteurs.get(numlecteur);
        ihm.afficherLecteur(l);
    }

    public Set<Integer> listeNumLec() {
        return lecteurs.keySet();
    }

    public Map<Integer, Lecteur> getLecteurs() {
        return this.lecteurs;
    }

    private int IncrementerNumLecteur() {
        return dernnumlect++;
    }

    private void lierLecteur(Lecteur l, Integer num) {
        this.lecteurs.put(num, l);
    }

    //-----  méthodes concernant la classe ouvrage -------------

    public void nouvelOuvrage(IHM ihm) {
        IHM.InfosOuvrage infosOuvrage = ihm.saisirOuvrage();

        Ouvrage o;

        o = new Ouvrage(infosOuvrage.isbn, infosOuvrage.Auteur, infosOuvrage.nomEditeur, infosOuvrage.dateParution, infosOuvrage.titre, infosOuvrage.typePublic);
        lierOuvrage(o, infosOuvrage.isbn);
        ihm.informerUtilisateur("création de l'ouvrage de numéro ISBN : " + infosOuvrage.numISBN, true);

    }


    public void ConsulterOuvrage(IHM ihm) {


        Set <String> listIsbnS = getlistIsbnS();

        Ouvrage o = getOuvrage(ihm.saisirIsbn(listIsbnS));
        String isbn = o.getIbsn();
        String t = o.gettitre();
        String a = o.getAuteur();
        String ed = o.getNomEditeur();
        Date de = o.getdateParution();

        ihm.afficherOuvrage(isbn, t, a, ed, de);

    }

    public Set<String> getlistIsbnS() {
        return this.ouvrages.keySet();
    }




    public Ouvrage getOuvrage(String isbnverif){

        return ouvrages.get(isbnverif);
    }



    private void lierOuvrage(Ouvrage o, String isbn) {
        this.ouvrages.put(isbn, o);
    }

}

    //-----  méthodes concernant la classe exemplaire -------------//
    public void NouvelExemplaire(IHM ihm) {
        Set<String> listIsbnS = getlistIsbnS();
        IHM.InfosExemplaire InfosExemplaire = ihm.saisirExemplaire();
        Ouvrage o;
        Integer NbeNonEmprunt;
        if (listIsbnS.contains(InfosExemplaire.isbnSaisie)) {
            o = getOuvrage(InfosExemplaire.isbnSaisie);
            NbeNonEmprunt = InfosExemplaire.nbExemplaire - InfosExemplaire.nbeEmpruntable;
            o.ajoutExempEmpruntab(InfosExemplaire.dateRecepExemp, InfosExemplaire.nbeEmpruntable, o);
            o.ajoutExempNONEmpruntab(InfosExemplaire.dateRecepExemp, NbeNonEmprunt, o);
            ihm.informerUtilisateur("Réussite de la création des exemplaires ", true);

        } else {
            ihm.informerUtilisateur("ISBN incorrect. Veuillez resaisir. ", false);
        }
    }

    public void ConsulterExemplairesOuvrage(IHM ihm) {
        Set<String> listIsbnS = getlistIsbnS();
        Ouvrage o = getOuvrage(ihm.saisirIsbn(listIsbnS));

        String t = o.gettitre();

        Integer eS = getExemplaireS(t);

        for(int i = 0; i < eS; i++){

        }

    }

}
