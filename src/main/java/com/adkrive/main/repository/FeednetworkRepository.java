package com.adkrive.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.FeedNetwork;

@Repository
public interface FeednetworkRepository extends JpaRepository<FeedNetwork, Integer>{


@Query("FROM FeedNetwork AS f LEFT JOIN f.feeds AS f WHERE f.status =true") 
public List<FeedNetwork> getAllActiveNetwork();
	

    
}
