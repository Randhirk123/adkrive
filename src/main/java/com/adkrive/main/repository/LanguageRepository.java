package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
