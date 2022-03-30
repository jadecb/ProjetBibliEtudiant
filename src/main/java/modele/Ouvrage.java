package modele;

import vue.IHM;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


public class Ouvrage implements Serializable {

    private final String ibsn;
    private final String titre;
    private final String Auteur;
    private final String nomEditeur;
    private final Date dateParution;
    private int dernierExemplaire = 1;
    private final HashSet<Exemplaire> exemplaires;
    private final Public typePublic;

    public Ouvrage(String ibsn, String titre, String Auteur, String nomEditeur, Date dateParution, int dernierExemplaire, Public typePublic) {
        this.ibsn = ibsn;
        this.titre = titre;
        this.Auteur = Auteur;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
        this.dernierExemplaire = 1 ;
        this.exemplaires = new HashSet<>();
        this.typePublic = typePublic;

    }

    public String getIbsn() {
        return ibsn;
    }

    public String gettitre() {
        return titre;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public Date getdateParution() {
        return dateParution;
    }

    public String getAuteur() {
        return Auteur;
    }

    public Public getTypePublic() {
        return typePublic;
    }

    public void setExemplaires (Exemplaire e) {
        exemplaires.add(e);
    }

    public void setExemplaire (Exemplaire e){
        this.setExemplaire(e);
    }

    public HashSet<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    private int IncrementerNumExemplaire() {
        return dernierExemplaire ++;
    }

    public void lierExemplaire(Exemplaire e) {
        this.exemplaires.add(e);
    }

   // public Integer ajoutExempNbreEmpruntab(LocalDate dateRecep){
    // Exemplaire.numExemp = IncrementerNumExemplaire(num);
    //    setEmpruntab = true;
    //    Exemplaire e= new Exemplaire(dateRecep, numEx, empruntab, this);
    //}

        //public Integer ajoutExempNbreNONEmpruntab(LocalDate dateRecep){
       // this.numEx = IncrementerNumExemplaire(numEx);
       // setEmpruntab = false;
       // Exemplaire e= new Exemplaire(dateRecep,this, setEmpruntab, numEx);

    // }

    public void ajouterExemplaire (LocalDate dateReception, Integer numEx, Boolean empruntab, Ouvrage o)
    {
        Exemplaire e;
        this.IncrementerNumExemplaire();
        e= new Exemplaire(dateReception, numEx, empruntab, this);
        setExemplaire(e);
        this.lierExemplaire(e);
    }
}

