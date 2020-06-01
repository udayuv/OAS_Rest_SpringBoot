package com.cybage.surfer.OAS.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subtopic")
public class SubTopic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="s_name")
	private String sName;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER,mappedBy="subtopic",cascade = CascadeType.ALL)
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<CourseSubTopic> course_subtopic;
	
	public SubTopic() {
		System.out.println("in default ctor of subtopic");
	}

	public SubTopic(Integer id, String sName) {
		super();
		this.id = id;
		this.sName = sName;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public List<CourseSubTopic> getCourse_subtopic() {
		return course_subtopic;
	}

	public void setCourse_subtopic(List<CourseSubTopic> course_subtopic) {
		this.course_subtopic = course_subtopic;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}


	@Override
	public String toString() {
		return "SubTopic [id=" + id + ", name=" + sName + "]";
	}
	
	
}
