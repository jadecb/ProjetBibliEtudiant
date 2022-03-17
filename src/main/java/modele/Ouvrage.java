package modele;

import java.io.Serializable;
import java.time.LocalDate;



public class Ouvrage implements Serializable {

    private final String ibsn;
    private final String titre;
    private final String Auteur;
    private final String nomEditeur;
    private final LocalDate dateParution;

    public Ouvrage(String ibsn, String titre, String Auteur, String nomEditeur, LocalDate dateParution) {
        this.ibsn = ibsn;
        this.titre = titre;
        this.Auteur = Auteur;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
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

    public LocalDate getdateParution() {
        return dateParution;
    }

    public String getAuteur() {
        return Auteur;
    }
}

