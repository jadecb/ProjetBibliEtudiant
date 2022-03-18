package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import vue.IHM;


public class Bibliotheque implements Serializable {

    private static final long serialVersionUID = 1L;  // nécessaire pour la sérialisation
    private Map<Integer, Lecteur> lecteurs;
    private Map<String, Ouvrage> ouvrages;
    private int dernnumlect;

    public Bibliotheque() {
        this.lecteurs = new HashMap<>();
        this.ouvrages = new HashMap<>();
        this.dernnumlect = 0;
    }

    public void nouveauLecteur(IHM ihm) {
        IHM.InfosLecteur infosLecteur = ihm.saisirLecteur();
        Lecteur l = lecteurs.get(infosLecteur.num);
        if (l == null) {
            l = new Lecteur(infosLecteur.num, infosLecteur.nom, infosLecteur.prenom, infosLecteur.dateNaiss, infosLecteur.email);
            lierLecteur(l, infosLecteur.num);
            ihm.informerUtilisateur("création du lecteur de numéro : " + infosLecteur.num, true);

        } else {
            ihm.informerUtilisateur("numéro de lecteur existant", false);
        }
    }

    public Map<Integer, Lecteur> getLecteurs() {
        return this.lecteurs;
    }

    private void lierLecteur(Lecteur l, Integer num) {
        this.lecteurs.put(num, l);
    }

    //-----  méthodes concernant la classe ouvrage -------------
    public void nouvelOuvrage(IHM ihm) {
        IHM.InfosOuvrage infosOuvrage = ihm.saisirOuvrage();
        Ouvrage o = ouvrages.get(infosOuvrage.isbn);

        if (o == null) {
            o = new Ouvrage(infosOuvrage.isbn, infosOuvrage.titre, infosOuvrage.Auteur, infosOuvrage.nomEditeur, infosOuvrage.dateParution);
            lierOuvrage(o, infosOuvrage.isbn);
            ihm.informerUtilisateur("création de l'ouvrage : " + infosOuvrage.isbn, true);
        } else {
            ihm.informerUtilisateur("L'ouvrage existe déjà.", false);
        }
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
