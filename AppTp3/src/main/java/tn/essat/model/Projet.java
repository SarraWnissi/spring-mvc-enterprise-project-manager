package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Projet {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String etat;  // non lancé, active, achevé (TP2)

    @ManyToOne @JoinColumn(name = "dept_id")
    private Departement dept;

    public Projet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Projet(Integer id, String titre, String etat) {
        super();
        this.id = id;
        this.titre = titre;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }
}