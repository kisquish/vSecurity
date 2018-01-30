package com.ptc.finance.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.NaturalId;

@Entity(name="contribution")
public class Contribution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idContribution;
	
	@ManyToOne(optional = false)
	private PTCUserName contributor;
	
	@Column(nullable = false, name ="contribution_amount")
	private double amount;
	
	@Column(nullable = false , name ="contribution_created")
	private Date created = new Date();
	
	@Column(nullable = false, name ="contribution_updated")
	private Date updated = new Date();

	@PreUpdate
	public void setLastUpdate() {  this.updated = new Date(); }
	
	protected Contribution() {
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
