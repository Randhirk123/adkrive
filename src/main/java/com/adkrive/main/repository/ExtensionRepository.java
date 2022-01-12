package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.Extension;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Integer>{

}
