package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.RestClientRegistration;

@Repository
public interface RestClientRepository extends JpaRepository<RestClientRegistration, Long> {

	@Query("SELECT r FROM RestClientRegistration r WHERE r.username = ?1")
	RestClientRegistration findByUsername(String username);

	
}
