package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.WithDrawMethod;

@Repository
public interface WithdrawMethodRepository extends JpaRepository<WithDrawMethod, Integer>{

	

}
