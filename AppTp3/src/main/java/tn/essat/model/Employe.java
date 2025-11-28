package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String fonction;  // Ajout TP2 : manager, ingénieur, technicien

    @ManyToOne @JoinColumn(name = "dept_id")
    private Departement dept;

    @ManyToOne @JoinColumn(name = "proj_id")
    private Projet proj;

    public Employe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employe(Integer id, String nom, String fonction) {
        super();
        this.id = id;
        this.nom = nom;
        this.fonction = fonction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public Projet getProj() {
        return proj;
    }

    public void setProj(Projet proj) {
        this.proj = proj;
    }
}