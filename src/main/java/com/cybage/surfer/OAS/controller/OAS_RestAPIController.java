package com.cybage.surfer.OAS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.surfer.OAS.model.Question;
import com.cybage.surfer.OAS.model.Results;
import com.cybage.surfer.OAS.model.SubTopic;
import com.cybage.surfer.OAS.model.UserSelectedChoices;
import com.cybage.surfer.OAS.model.Users;
import com.cybage.surfer.OAS.service.UserService;


@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:3000")
public class OAS_RestAPIController {
	
	@Autowired
	private UserService userServices;
	

	//new user registration control
	@CrossOrigin
	@RequestMapping(value="/create",method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public String createUser(@RequestBody Users u){
		userServices.addUsers(u);
		return "user added successfully";
	}
	
	//user login control
	@RequestMapping(value="/login",method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Users  Login(@RequestBody Users u){
		 	
		Users loggedUser =userServices.validateUser(u.getEmail(), u.getPassword());
		return loggedUser;
		
	}
	
	//control to find user
	@CrossOrigin
	@RequestMapping(value="/user/{id}",produces="application/json")
    public Users getUserId(@PathVariable("id") int id)
    {
        Users u = userServices.findUser(id);
        return u;
    }
	
	 //control to show report of user
	 @RequestMapping(value="/report/{id}",produces="application/json")
	    public List<Object> getUserReport(@PathVariable("id") int id)
	    {
		 List<Object> reportData = new ArrayList<>();
		 List<SubTopic> subtopic ;
		 
		 	// User Details 
		 	Users user = getUserId(id); 
		 	
		 	//Subtopics
		 	subtopic = userServices.getSubtopic();
		 	
		 	//Results of User
	        List<Results> userReport = userServices.getReport(id);
	        
	        //Adding all to reportData
	        reportData.add(user);
	        reportData.add(subtopic);
	        reportData.add(userReport);
	        
	        return reportData;
	        
	        
	    }
	//control to show all users
	 @RequestMapping(value="/users",produces="application/json")
	    public List<Users> getAllUsers()
	    {
	        List<Users> usrList = userServices.showUser();
	        return usrList;
	    }
	 
	 
	 //control to update user
	 @RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	    public String updateUser(@RequestBody Users u)
	    {
		 userServices.updateUser(u);
	        return " user details updated successfully";
	    }
	    
	  //control to delete user
	    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET, produces="application/json")
	    public String deleteUser(@PathVariable("id") int id)
	    {
	    	userServices.deleteUser(id);
	        return " user deleted successfully"+id;
	    }
	    
	    /*
	     * control method related to question table
	     * 
	     * */
	    //control to get all questions
		 @RequestMapping(value="/quiz",produces="application/json", method=RequestMethod.GET)
		    public List<Question> getAllQuestions()
		    {
		        List<Question> questionList = userServices.getQuestion();
		        return questionList;
		    }
		 
		 //control to set the result
		 @CrossOrigin
			@RequestMapping(value="/testsubmitted",method=RequestMethod.POST, produces="application/json", consumes="application/json")
			public String createUser(@RequestBody List<UserSelectedChoices> selectedAnswers){
				userServices.checkUserSelectedAnswer(selectedAnswers);
				return "answer added successfully";
			}
		 
		//control to get the result
		 @CrossOrigin
			@RequestMapping(value="/getresult/{id}",produces="application/json")
			public  List<Results>  getResult(@PathVariable("id") int id){
			 List<Results> resultsList =userServices.getStudentResult(id);
				return  resultsList;
			}
}
