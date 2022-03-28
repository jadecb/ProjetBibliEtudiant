package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Exemplaire implements Serializable {


    private static final long serialVersionUID = 1L;  // nécessaire pour la sérialisation
    private LocalDate dateRecepExemp;
    private Integer numExemp;
    private Boolean empruntab;
    private Ouvrage ouvrage;

    public Exemplaire(LocalDate dateRecepExemp, Integer numEx, Boolean empruntab, Ouvrage o) {
        this.dateRecepExemp = dateRecepExemp;
        this.numExemp = numEx;
        this.empruntab = empruntab;
        this.ouvrage = o;
    }

    public Boolean getEmpruntab() {
        return empruntab;
    }

    public Integer getNumExemp() {
        return numExemp;
    }

    public LocalDate getDateRecepExemp() {
        return dateRecepExemp;
    }

    public void lierOuvrage(Ouvrage o){
        o = this.ouvrage;
    }

    public void setEmpruntab(Boolean empruntab) {
        this.empruntab = empruntab;
    }


}


