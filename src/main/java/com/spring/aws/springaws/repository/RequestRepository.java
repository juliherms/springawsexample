package com.spring.aws.springaws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.aws.springaws.domain.Request;
import com.spring.aws.springaws.domain.enums.RequestState;

/**
 * This class responsible to provide access to Request table.
 * 
 * @author j.a.vasconcelos
 *
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	/**
	 * Return list all requests for user/owner id.
	 * 
	 * @param id
	 * @return
	 */
	public List<Request> findAllByOwnerId(Long id);

	/**
	 * Method responsible to update state request
	 * 
	 * @param id
	 * @param state
	 * @return
	 */
	@Query("UPDATE REQUEST SET state = ?2 WHERE id = ?1")
	public Request updateStatus(Long id, RequestState state);
}
