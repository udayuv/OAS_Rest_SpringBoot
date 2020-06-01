package com.cybage.surfer.OAS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String question;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String corr_ans;
	private int marks;
	private String dlevel;
	
/*	@OneToOne(mappedBy="ques")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Exam exam;*/
	
	@ManyToOne
	@JoinColumn(name = "cs_id", nullable=false)
	//@JsonBackReference
	private CourseSubTopic course_subtopic;
	
	@ManyToOne
	@JoinColumn(name="admin_id", nullable=false)
	private Users user;
	
		
	@Transient
	private MultipartFile file ;
	
	public Question(){
		//No-arg constructor
	}

	public Question(Integer id, String question, String opt1, String opt2, String opt3, String opt4, String corr_ans,
			int marks, String dlevel, CourseSubTopic course_subtopic, Users user) {
		super();
		this.id = id;
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.corr_ans = corr_ans;
		this.marks = marks;
		this.dlevel = dlevel;
		this.course_subtopic = course_subtopic;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public String getCorr_ans() {
		return corr_ans;
	}

	public void setCorr_ans(String corr_ans) {
		this.corr_ans = corr_ans;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getDlevel() {
		return dlevel;
	}

	public void setDlevel(String dlevel) {
		this.dlevel = dlevel;
	}

	public CourseSubTopic getCourse_subtopic() {
		return course_subtopic;
	}

	public void setCourse_subtopic(CourseSubTopic course_subtopic) {
		this.course_subtopic = course_subtopic;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
				+ ", opt4=" + opt4 + ", corr_ans=" + corr_ans + ", marks=" + marks + ", dlevel=" + dlevel
				+ ", course_subtopic=" + course_subtopic + ", user=" + user + ", file=" + file + "]";
	}

	
	
	
	
}
