package com.example.RegisterLogin.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RegisterLogin.Entity.RegisterUser;

@Repository
public interface EmployeeRepo extends MongoRepository<RegisterUser, String> {
	
	@Query("{ 'email' : { $regex: ?0, $options: 'i' } }")
	RegisterUser findByEmailIgnoreCase(String email);

	Optional<RegisterUser> findOneByEmailAndPassword(String email, String encodedPassword);

	RegisterUser findByEmail(String email);

}
