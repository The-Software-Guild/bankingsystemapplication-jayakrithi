package com.banking.dto;
import java.time.LocalDate;

import com.banking.exceptions.InsufficientBalanceException;

public class SavingsAccount extends BankAccount {
	private Boolean isSalaryAcc;
	private long minBalance = 100;
	private long deposit;
	private long withdraw;  

	public SavingsAccount(long accountNumber, long bSBCode, String bankName, double balance, LocalDate openingdate) {
		super(accountNumber, bSBCode, bankName, balance, openingdate);
	}
	
	public Boolean getIsSalaryAcc() {
		return isSalaryAcc;
	}

	public void setIsSalaryAcc(Boolean isSalaryAcc) {
		this.isSalaryAcc = isSalaryAcc;
	}

	public long getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(long minBalance, Boolean isSalaryAcc) throws InsufficientBalanceException {
		String msg = "Transaction Failed ; your balance upon withdrawal is below the minimum balance" ;
		if(minBalance > 100 && isSalaryAcc.equals(true)) {
			 this.minBalance = minBalance;
		 }  
		else {
			InsufficientBalanceException insufBalance = new InsufficientBalanceException(msg);
		}
	}
	
	public void balanceonWithdrawal(long withdraw) {
		minBalance = minBalance - withdraw;
	}

	@Override
	public void calculateInterest() {
		// 4%
		double bal = this.getBalance();
		bal = this.getBalance()*0.04;
		this.setBalance(bal);
		
	}

}
