package com.spring.aws.springaws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.aws.springaws.domain.RequestStage;

/**
 * This class responsible to access RequestStage
 * 
 * @author j.a.vasconcelos
 *
 */
@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

	/**
	 * Find all stage by id request.
	 * 
	 * @param id
	 * @return
	 */
	public List<RequestStage> findAlByRequestId(Long id);

}
