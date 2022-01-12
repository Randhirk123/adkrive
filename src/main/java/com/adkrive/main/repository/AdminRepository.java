package com.adkrive.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adkrive.main.model.Admin;

@Repository

@Transactional
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT e FROM Admin e WHERE e.email = ?1")
	public Admin findByEmail(String email);
	
	@Query("SELECT a FROM Admin a WHERE a.userName = ?1")
	public Admin findByUsername(String userName);

	public Admin findByResetPasswordToken(String token);
	public Admin findByImage(byte[] image);

	@Query("SELECT a FROM Admin a")
	public Admin getAllDetails();



	
	
	
	@Query("UPDATE Admin a SET a.failedAttempt = ?1 WHERE a.userName = ?2")
	@Modifying
	public void updateFailedAttempts(int failAttempts, String username);

	
	@Query("SELECT a  FROM Admin a WHERE a.userName=?1")
	public Admin findByUserNameAndPassword(String userName);
	@Transactional
	@Modifying
	@Query("update Admin a SET a.name =:name, a.email =:email,a.image=:image")
	void updateAdmin(@Param(value = "name") String name, @Param(value = "email") String email,@Param(value = "image") byte[] image);


}
