package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class Ouvrage implements Serializable {

    private final String ibsn;
    private final String titre;
    private final String Auteur;
    private final String nomEditeur;
    private final LocalDate dateParution;
    private final int dernierExemplaire;
    private final Set <Exemplaire> exemplaires;

    public Ouvrage(String ibsn, String titre, String Auteur, String nomEditeur, LocalDate dateParution, int dernierExemplaire) {
        this.ibsn = ibsn;
        this.titre = titre;
        this.Auteur = Auteur;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
        this.dernierExemplaire = 0 ;
        this.exemplaires = new Set<Exemplaire>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Exemplaire> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Exemplaire exemplaire) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Exemplaire> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
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

    public LocalDate getdateParution() {
        return dateParution;
    }

    public String getAuteur() {
        return Auteur;
    }
}

