package com.spring.aws.springaws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.aws.springaws.domain.User;
import com.spring.aws.springaws.domain.enums.Role;

/**
 * This class represent user repository in the system
 * @author j.a.vasconcelos
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find user by email and password
	 * @param email
	 * @param password
	 * @return User
	 */
	@Query("SELECT u FROM user u WHERE email = ?1 AND password = ?2")
	public Optional<User> login(String email, String password);
	
	/**
	 * Update role by User
	 * @param id - id user
	 * @param role - role
	 * @return
	 */
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE user SET role = ?2 WHERE id = ?1")
	public int updateRole(Long id, Role role);
	
	/**
	 * Find user by email.
	 * @param email
	 * @return
	 */
	public Optional<User> findByEmail(String email);
}
