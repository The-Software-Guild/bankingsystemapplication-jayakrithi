package com.banking.dto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerDTO {
	private int customerId;
	private static int generateCustomerId = 100;
	private String customerName;
	private int customerAge;
	private long customerMobilenumber;
	private String customerPassportnumber;	
	private BankAccount account;
	private String DOB;
	static final String CUSTOM_PATTERN = "dd-mm-yyyy";
	static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(CUSTOM_PATTERN);
	
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		if(checkDOB(dOB)) {
			DOB = dOB;
		}
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public long getCustomerMobilenumber() {
		return customerMobilenumber;
	}
	public void setCustomerMobilenumber(long customerMobilenumber) {
		this.customerMobilenumber = customerMobilenumber;
	}
	public String getCustomerPassportnumber() {
		return customerPassportnumber;
	}
	public void setCustomerPassportnumber(String customerPassportnumber) {
		this.customerPassportnumber = customerPassportnumber;
	}
	public boolean checkDOB(String dob) {
		try {
			LocalDate dobDate = LocalDate.parse(dob, DATE_TIME_FORMATTER);
			return true;
		}catch(DateTimeParseException e) {
			System.out.println("Please enter a Valid Date");
			return false;
		}
	}
	
    public CustomerDTO(String customerName, int customerAge, long newCustomerMobilenumber,
			String customerPassportnumber) {
		this.customerId = generateCustomerId+1;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerMobilenumber = newCustomerMobilenumber;
		this.customerPassportnumber = customerPassportnumber;
	}
    
    
	@Override
	public String toString() {
		return "CustomerData [customerId= "+customerId+" customerName=" + customerName + ", customerAge=" + customerAge + ", customerMobilenumber="
				+ customerMobilenumber + ", customerPassportnumber=" + customerPassportnumber + "] \n";
	}

}
