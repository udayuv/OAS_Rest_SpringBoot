package com.cybage.surfer.OAS.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.surfer.OAS.model.CourseSubTopic;
import com.cybage.surfer.OAS.model.Question;
import com.cybage.surfer.OAS.model.Results;
import com.cybage.surfer.OAS.model.SubTopic;
import com.cybage.surfer.OAS.model.UserSelectedChoices;
import com.cybage.surfer.OAS.model.Users;
import com.cybage.surfer.OAS.repository.CourseSubTopicRepository;
import com.cybage.surfer.OAS.repository.ResultRepository;
import com.cybage.surfer.OAS.repository.UserRepository;
import com.cybage.surfer.OAS.service.UserService;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@PersistenceContext
    private EntityManager entityManager;

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ResultRepository resultrepo;
	@Autowired
	private CourseSubTopicRepository csRepository;

	//add a user
	public void addUsers(Users u) {
		userRepository.save(u);
	}

	//fetching all users
	public List<Users> showUser(){
		return userRepository.findAll();
	}
	
	//finding user by id
	public Users findUser(int id) {
		return userRepository.findById(id);
	}

	//updating a user
	public void updateUser(Users user) {
		entityManager.merge(user);
	}

	//deleting a user
	public void deleteUser(int id) {
		Users user=userRepository.findById(id);
		userRepository.delete(user);
	}

	//authenticate the user
	public Users  validateUser(String email,String password) {
		Users user =userRepository.authenticateUser(email, password);
	
			if(user!=null){
				System.out.println("logged in successfully");
				return user;
			}
			else {
				System.out.println("invalid credentials");
				return user;
			}
	}
	
	@Override
	public List<Results> getReport(int id) {
		
		return (List<Results>) resultrepo.getAllResultsByStd_Id(id);
	}
	
	@Override
	public List<SubTopic> getSubtopic() {
		
		return userRepository.getSubtopic();
	}
	
	//fetching all question
	@Override
	public List<Question> getQuestion() {
		return (List<Question>) userRepository.getAllQuestion();
	}
	

	@Override
	public void checkUserSelectedAnswer(List<UserSelectedChoices> userSelectedChoice) {
		Question ques=null;
		int obt_marks=0,total_marks=0;
		int cs_id=0;
		Users user=new Users();
		
		for (UserSelectedChoices usc : userSelectedChoice) {
			ques= userRepository.getQuestionById(usc.getQid());
			total_marks += ques.getMarks();
			cs_id =ques.getCourse_subtopic().getId();
			if(ques.getCorr_ans().equals(usc.getAns())){
				obt_marks += ques.getMarks();
			}
		}
		String start_time =new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String date =new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		double percentage=  (obt_marks/total_marks)*100;
		System.out.println("------------percent: "+percentage);
		System.out.println("------------------------------------------------------");
		System.out.println(cs_id +" "+ obt_marks+" "+total_marks);
		user = userRepository.findById(1);
		CourseSubTopic csTopic = csRepository.findById(cs_id);
		int res_id =user.getId()+100+obt_marks;
		System.out.println("result id: "+res_id);
		Results res =new Results(res_id, total_marks, obt_marks, percentage, date,start_time,csTopic,user );
		resultrepo.save(res);
	}

	
	@Override
	public List<Results> getStudentResult(int id) {
		return (List<Results>) resultrepo.getAllResultsByStd_Id(id);
	}

	
		

}
