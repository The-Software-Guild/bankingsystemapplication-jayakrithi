package com.banking.dto;
import java.time.LocalDate;

public class FixedDeposit extends BankAccount {
	private long depositAmt = 1000;
	private int tenure; 
	private double interestEarned ; 
	
	public double getInterestEarned() {
		return interestEarned;
	}
	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}
	public long getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(long depositAmt) {
		if(depositAmt >= 1 && depositAmt <=7) {
			this.depositAmt = depositAmt;
		}
		else if(depositAmt <1) {
			this.depositAmt = 1;
		}
		else if(depositAmt > 7) {
			this.depositAmt = 7;
			}
	}
	
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public FixedDeposit(long accountNumber, long bSBCode, String bankName, double balance, LocalDate openingdate) {
		super(accountNumber, bSBCode, bankName, balance, openingdate);
	}
	@Override
	public void calculateInterest() {
		// 8%
		long amt = depositAmt;
		amt = (long) ((depositAmt*0.08) * tenure);
		interestEarned = amt - depositAmt;
	}

}
