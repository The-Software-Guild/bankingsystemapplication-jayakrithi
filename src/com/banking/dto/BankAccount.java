package com.banking.dto;
import java.time.LocalDate;

public abstract class BankAccount {
	private long accountNumber;
	private long BSBCode;
	private String bankName;
	private double balance;
	private LocalDate Openingdate;
	private String accountType;
	private static double SAVINGS_ACC_INTEREST = 4;
	private static double FIXED_DEPOSIT_INTEREST = 8;
	public String getAccountType() {
		return accountType;
	}

	public double returnInterest(String s) {
		if(s.equals("Savings Account")) {
			return SAVINGS_ACC_INTEREST;
		}else 
		return FIXED_DEPOSIT_INTEREST;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public abstract void calculateInterest();

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBSBCode() {
		return BSBCode;
	}

	public void setBSBCode(long bSBCode) {
		BSBCode = bSBCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getOpeningdate() {
		return Openingdate;
	}

	public void setOpeningdate(LocalDate openingdate) {
		Openingdate = openingdate;
	}
	
	public BankAccount(long accountNumber, long bSBCode, String bankName, double balance, LocalDate openingdate) {
		super();
		this.accountNumber = accountNumber;
		BSBCode = bSBCode;
		this.bankName = bankName;
		this.balance = balance;
		Openingdate = openingdate;
	}
}
