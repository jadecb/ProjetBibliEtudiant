package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Exemplaire implements Serializable{
    
    private final Integer numExemplaire;
    private LocalDate dateRecepExemp;
    private boolean empruntable;
    
    public Exemplaire(Integer numExemplaire, LocalDate dateRecepExemp, boolean empruntable) {
    this.numExemplaire = numExemplaire;
    this.dateRecepExemp = dateRecepExemp;
    this.empruntable = empruntable;
    }
    
    public Integer getnumExemplaire() {
        return numExemplaire;
    }
    
    public LocalDate getdateRecepExemp() {
        return dateRecepExemp;
    }
    public boolean getempruntable() {
        return empruntable;
    }
}