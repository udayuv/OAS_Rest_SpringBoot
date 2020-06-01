package com.cybage.surfer.OAS.model;


import javax.persistence.*;

@Entity
@Table(name="results")
public class Results {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int total_marks;
	private int obtained_marks;
	private double percentage;
	private String date;
	private String start_time;
	
	@ManyToOne
	@JoinColumn(name = "cs_id",nullable=false)
	private CourseSubTopic courseSubTopic;
	
	@ManyToOne
	@JoinColumn(name="std_id", nullable=false)
	private Users user;
	
	public Results() {
		System.out.println("in default ctor of results");
	}

	public Results(Integer id, int total_marks, int obtained_marks, double percentage, String date, String start_time,
			CourseSubTopic courseSubTopic, Users user) {
		super();
		this.id = id;
		this.total_marks = total_marks;
		this.obtained_marks = obtained_marks;
		this.percentage = percentage;
		this.date = date;
		this.start_time = start_time;
		this.courseSubTopic = courseSubTopic;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}

	public int getObtained_marks() {
		return obtained_marks;
	}

	public void setObtained_marks(int obtained_marks) {
		this.obtained_marks = obtained_marks;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public CourseSubTopic getCourseSubTopic() {
		return courseSubTopic;
	}

	public void setCourseSubTopic(CourseSubTopic courseSubTopic) {
		this.courseSubTopic = courseSubTopic;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
	
}
