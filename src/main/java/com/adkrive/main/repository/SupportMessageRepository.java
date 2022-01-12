package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.SupportMessage;

@Repository
public interface SupportMessageRepository extends JpaRepository<SupportMessage, Integer>{

}
