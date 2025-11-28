package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.User;

@Repository
public interface IUser extends JpaRepository<User, Integer> {
	//chercher un user par password w username dsl, bel findby (5ter fi meme classe)
		User findByUsernameAndPassword(String s1, String s2);
}

