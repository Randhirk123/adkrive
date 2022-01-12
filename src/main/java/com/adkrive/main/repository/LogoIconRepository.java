package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.LogoIconSetting;

@Repository
public interface LogoIconRepository extends JpaRepository<LogoIconSetting, Integer> {

	@Query("SELECT f FROM LogoIconSetting f")
	public LogoIconSetting getLogoIconDetails();
}
