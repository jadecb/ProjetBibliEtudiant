package modele;

import java.io.Serializable;
import java.time.LocalDate;


public class Ouvrage implements Serializable {
    private final String ibsn;
    private String titre;
    private String nomEditeur;
    private LocalDate dateParution;
    private String auteur;

    public Ouvrage(String ibsn, String titre, String nomEditeur, LocalDate dateParution) {
        this.ibsn = ibsn;
        this.titre = titre;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
        this.auteur= auteur;
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
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}

