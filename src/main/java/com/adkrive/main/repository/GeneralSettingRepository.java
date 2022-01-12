package com.adkrive.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.GlobalSetting;

@Repository
public interface GeneralSettingRepository extends JpaRepository<GlobalSetting, Integer> {

	@Query("SELECT g FROM GlobalSetting g")
	public GlobalSetting getGeneralSetting();
}
