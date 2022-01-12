package com.adkrive.main.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.Feeds;

@Repository
public interface FeedsRepository extends JpaRepository<Feeds, Long> {

	
	@Query("FROM Feeds AS f LEFT JOIN f.feedNetwork AS fn WHERE f.status = true") 
	public List<Feeds> getAllActiveFeeds();
	@Query("SELECT f FROM Feeds f")
	public Feeds getFeeds();
	
	@Transactional
	@Modifying
	@Query("update Feeds f set f.checker = :checker")
	public void updateCheckerStatus(@Param("checker") Integer checker);
	
	@Query("SELECT f FROM Feeds f WHERE f.checker =1")
	public List<Feeds> getAllChecker();
	

}
