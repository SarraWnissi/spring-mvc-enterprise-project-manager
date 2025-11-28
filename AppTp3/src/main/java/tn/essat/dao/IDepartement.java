package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Departement;

@Repository
public interface IDepartement extends JpaRepository<Departement, Integer> {
	
}
