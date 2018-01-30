package com.ptc.finance.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="ptcusername")
public class PTCUserName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idPTCUserName;

	@Column(nullable = false, name="ptcuser_name")
	private String name;

	@OneToMany
	private List<Contribution> contribution;
	
	public List<Contribution> getContribution() {
		return contribution;
	}

	public void setContribution(List<Contribution> contribution) {
		this.contribution = contribution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PTCUserName(String name) {
		super();
		this.name = name;
	}
	
	public PTCUserName (){}
}
