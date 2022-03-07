package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Ouvrage implements Serializable {
    private final Integer ibsn;
    private String titre;
    private String nomEditeur;
    private Date dateParution;

    public Ouvrage(Integer ibsn, String titre, String nomEditeur, Date dateParution) {
        this.ibsn = ibsn;
        this.titre = titre;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
    }

    public Integer getIbsn() {
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
}

