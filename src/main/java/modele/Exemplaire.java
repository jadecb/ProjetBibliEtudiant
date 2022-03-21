package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Exemplaire implements Serializable {


    private static final long serialVersionUID = 1L;  // nécessaire pour la sérialisation
    private Integer numExemp;
    private LocalDate dateRecepExemp;
    private Boolean empruntab;
    private Ouvrage ouvrage;

    public Exemplaire(Integer numEx, LocalDate dateRecepExemp, Boolean empruntab, Ouvrage o) {
        this.numExemp = numEx;
        this.dateRecepExemp = dateRecepExemp;
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


