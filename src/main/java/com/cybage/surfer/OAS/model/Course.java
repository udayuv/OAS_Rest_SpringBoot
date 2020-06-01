package com.cybage.surfer.OAS.model;



import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="c_name")
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER,mappedBy="course",cascade = CascadeType.ALL)
	private List<CourseSubTopic> course_sub_topic;
	
	public Course() {
		System.out.println("in default ctor of course");
	}

	public Course(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public List<CourseSubTopic> getCourse_sub_topic() {
		return course_sub_topic;
	}

	public void setCourse_sub_topic(List<CourseSubTopic> course_sub_topic) {
		this.course_sub_topic = course_sub_topic;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	
}
