package com.cybage.surfer.OAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.surfer.OAS.model.CourseSubTopic;
import com.cybage.surfer.OAS.model.Question;
import com.cybage.surfer.OAS.model.SubTopic;
import com.cybage.surfer.OAS.model.UserSelectedChoices;
import com.cybage.surfer.OAS.model.Users;


@Repository("user")
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	@Query(value = "FROM Question ques ")
	 public List<Question> getAllQuestion();
	

	 @Query(value = "FROM Users user WHERE user.id = :id")
	 public Users findById(@Param("id") int id);
	 
	 //Authentication
	 @Query(value = "FROM Users user WHERE user.email=:email AND user.password=:password")
	 public Users authenticateUser(@Param("email") String email, @Param("password") String password);

	//get marks by question id
	 @Query(value = "Select q.marks, q.corr_ans FROM Question q WHERE q.id=:qid") 
	 public Question getMarksByQuestionId(@Param("qid") int qid);

	//get marks by question id
	 @Query(value = "FROM Question q WHERE q.id=:qid") 
	 public Question getQuestionById(@Param("qid") int qid);

	 @Query(value = "FROM SubTopic subtopic")
     public List<SubTopic> getSubtopic();
	 
	
	
}
