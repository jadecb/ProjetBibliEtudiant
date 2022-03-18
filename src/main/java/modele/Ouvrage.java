package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


public class Ouvrage implements Serializable {

    private final String ibsn;
    private final String titre;
    private final String Auteur;
    private final String nomEditeur;
    private final Date dateParution;
    private int dernierExemplaire;
    private final Set <Exemplaire> exemplaires;
    private final Public typePublic;
    private Integer numEx;

    public Ouvrage(String ibsn, String titre, String Auteur, String nomEditeur, Date dateParution, int dernierExemplaire, Public typePublic) {
        this.ibsn = ibsn;
        this.titre = titre;
        this.Auteur = Auteur;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
        this.dernierExemplaire = 0 ;
        this.typePublic = typePublic;
        this.exemplaires = new Set<Exemplaire>() {
        };
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

    public Integer ajoutExempEmpruntab(LocalDate dateRecep){
        this.numEx = IncrementerNumExemplaire(numEx);
        setEmpruntab = true;
        Exemplaire e= new Exemplaire(dateRecep,this, setEmpruntab, numEx);

    }

    private int IncrementerNumExemplaire(Integer numEx) {
         return numEx++;
    }

    private lierExemplaire (Exemplaire e){
        exemplaires.add(e);
    }

}

