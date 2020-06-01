package com.cybage.surfer.OAS.service;

import java.util.List;

import com.cybage.surfer.OAS.model.Question;
import com.cybage.surfer.OAS.model.Results;
import com.cybage.surfer.OAS.model.SubTopic;
import com.cybage.surfer.OAS.model.UserSelectedChoices;
import com.cybage.surfer.OAS.model.Users;


public interface UserService {
	
	public	void addUsers(Users u);
	public List<Users> showUser();
	public Users findUser(int id);
	public List<Question> getQuestion();
	public void updateUser(Users u);
    public void deleteUser(int id);
    public Users validateUser(String email,String passwd);
	void checkUserSelectedAnswer(List<UserSelectedChoices> userSelectedChoice);
	public List<Results> getStudentResult(int id);
	List<SubTopic> getSubtopic();
	public List<Results> getReport(int id);
}
