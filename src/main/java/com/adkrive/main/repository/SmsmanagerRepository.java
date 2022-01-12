package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.SmsManager;

@Repository
public interface SmsmanagerRepository extends JpaRepository<SmsManager, Integer> {

}
