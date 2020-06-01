package com.cybage.surfer.OAS.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name="course_subtopic")
public class CourseSubTopic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="course_subtopic",cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<Question> ques;
	
	@ManyToOne
	@JoinColumn(name="sub_topic_id", nullable=false)
	private SubTopic subtopic;
	
	@ManyToOne
	@JoinColumn(name="course_id", nullable=false)
	private Course course;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="courseSubTopic",cascade = CascadeType.ALL)
	private List<Results> results;
	
	public CourseSubTopic() {
		System.out.println("in default ctor of course-subtopic");
	}
	
	public CourseSubTopic(Integer id) {
		super();
		this.id = id;
	}
	
	
	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public List<Question> getQues() {
		return ques;
	}

	public void setQues(List<Question> ques) {
		this.ques = ques;
	}

	public SubTopic getSubtopic() {
		return subtopic;
	}

	public void setSubtopic(SubTopic subtopic) {
		this.subtopic = subtopic;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseSubTopic [id=" + id + "]";
	}

	
	

	
}
