package com.cybage.surfer.OAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.surfer.OAS.model.CourseSubTopic;

public interface CourseSubTopicRepository extends JpaRepository<CourseSubTopic, Integer> {

	 @Query(value = "FROM CourseSubTopic cs WHERE cs.id = :id")
	 public CourseSubTopic findById(@Param("id") int id);
}
