package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.essat.model.Employe;

@Repository
public interface IEmploye extends JpaRepository<Employe, Integer>{
	//yst7a9 query 5ter fama relation manytoone donc expl pour employe 2 relation
		@Query("select e from Employe e where e.proj.id=?1")//employe esm el classe
		public List<Employe> getListe1(int id);
		@Query("select e from Employe e where e.dept.id=?1")
		public List<Employe> getListe2(int id);
}
