package model;

public class Employe {
    private int id_emp;
    private String nom;
    private String email;
    private String poste;
    private double salaire;

    public Employe() {
    }

    public int getId() {
        return id_emp;
    }

    public void setId(int id_emp) {
        this.id_emp = id_emp;
    }  

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}