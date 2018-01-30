package org.ptc.webapp.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	//private Member leader;
	private String versionningLink;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Member> contributors;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
//	public Member getLeader() {
//		return leader;
//	}
//	public void setLeader(Member leader) {
//		this.leader = leader;
//	}
	public Set<Member> getContributors() {
		return contributors;
	}
	public void setContributors(Set<Member> contributor) {
		this.contributors = contributor;
	}
	
	public String getVersionningLink() {
		return versionningLink;
	}
	public void setVersionningLink(String versionningLink) {
		this.versionningLink = versionningLink;
	}
	public Project() {
		
		//For Spring :-)
	}
	
	public Project(String name, String description) {
		super();
		//this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("my ID : %d\n, my Name : %s\n, little Description : %s\n", id, name, description);
	}

}
