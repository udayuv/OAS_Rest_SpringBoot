package com.cybage.surfer.OAS.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {

	

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", role_id=" + role_id + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private String password;
	@Column(nullable = false)
	private String role_id;
	private String address;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Results> results;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Question> ques;

	public Users() {
		System.out.println("in default constructor of user");
	}

	public Users(Integer id, String firstname, String lastname, String gender, String role_id, String address,
			String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.role_id = role_id;
		this.email = email;
		this.password = password;
	}

	public Users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public List<Question> getQues() {
		return ques;
	}

	public void setQues(List<Question> ques) {
		this.ques = ques;
	}

}
