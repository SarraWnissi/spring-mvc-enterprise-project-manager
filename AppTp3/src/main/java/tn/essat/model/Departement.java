package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //integer badalnah 5ter nst3mlou fi spring data
	private String nom;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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
	

}
