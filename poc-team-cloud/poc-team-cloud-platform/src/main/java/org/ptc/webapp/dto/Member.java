package org.ptc.webapp.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String surName;
	private String firstName;
	private String lastName;
	private String role;
	private String linkedinUrlRef;
	private String githubUrlRef;
	
	@ManyToMany(mappedBy="contributors")
	private Set<Project> proj_Member;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLinkedinUrlRef() {
		return linkedinUrlRef;
	}
	public void setLinkedinUrlRef(String linkedinUrlRef) {
		this.linkedinUrlRef = linkedinUrlRef;
	}
	public String getGithubUrlRef() {
		return githubUrlRef;
	}
	public void setGithubUrlRef(String githubUrlRef) {
		this.githubUrlRef = githubUrlRef;
	}
	public Set<Project> getProject_Member() {
		return proj_Member;
	}
	public void setProject_Member(Set<Project> project_Member) {
		this.proj_Member = project_Member;
	}
	
	public Member() {
		
		//For Spring :-)
	}
	
	public Member(String lastName, String role) {
		super();
		//this.id = id;
		this.lastName = lastName;
		this.role = role;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("my ID : %d\n, my last Name is : %s\n, I am currently : %s\n", id, lastName, role);
	}

}
