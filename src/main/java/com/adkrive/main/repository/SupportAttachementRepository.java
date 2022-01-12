package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.SupportAttachment;

@Repository
public interface SupportAttachementRepository extends JpaRepository<SupportAttachment, Integer> {

	
}
