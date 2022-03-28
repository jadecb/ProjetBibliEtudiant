package modele;

public enum Public {
    ENFANT("Enfant",3), ADO("Adolescent",12), ADULTE("Adulte",18);



    private int ageMin ;
    private String libelle;

    Public(String libelle , int age){
        this.ageMin = age;
        this.libelle = libelle;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public String getLibelle() {
        return libelle;
    }

}

