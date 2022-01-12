package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.Frontend;

@Repository
public interface FrontendRepository  extends JpaRepository<Frontend, Integer> {

	@Query("SELECT f  FROM Frontend f WHERE f.id=1")
	public Frontend getSeoManagerData();
}
