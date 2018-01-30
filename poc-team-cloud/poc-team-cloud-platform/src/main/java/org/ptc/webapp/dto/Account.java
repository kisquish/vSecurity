package org.ptc.webapp.dto;

public class Account {

	private double solde ;
	private Operation op ;
	private double numTransaction ;
	


	public Account (){
		
	}
	
	public double getNumTransaction() {
		return numTransaction;
	}

	public void setNumTransaction(double numTransaction) {
		this.numTransaction = numTransaction;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Operation getOp() {
		return op;
	}
	public void setOp(Operation op) {
		this.op = op;
	}
	
	
}
