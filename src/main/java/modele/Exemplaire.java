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

    public Exemplaire(Integer numExemp, LocalDate dateRecepExemp, Boolean empruntab, Ouvrage o) {
        this.numExemp = numExemp;
        this.dateRecepExemp = dateRecepExemp;
        this.empruntab = empruntab;
        this.ouvrage = o;
    }
}


