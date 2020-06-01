package com.cybage.surfer.OAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.surfer.OAS.model.Results;

public interface ResultRepository extends JpaRepository<Results, Integer> {

	//@Query(value = "SELECT res.id, res.total_marks, res.obtained_marks, res.percentage, res.date, res.start_time, res.courseSubTopic.id FROM Results res where user.id = :id ")
	@Query(value = "FROM Results res where user.id = :id ")
	 public List<Results> getAllResultsByStd_Id(@Param("id") int id);
	
}
