package com.banking.controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.banking.dto.BankAccount;
import com.banking.dto.CustomerDTO;
import com.banking.dto.FixedDeposit;
import com.banking.dto.SavingsAccount;
import com.banking.service.CustomerServiceImp;

public class ApplicationMenu {
 //	static CustomerDTO[] list = new CustomerDTO[100000];
//	static int listIndex = 0;
	static List<CustomerDTO> list = new ArrayList<CustomerDTO>();
	CustomerServiceImp service = new CustomerServiceImp();
	public static void print(String s) {
		System.out.println(s);
	}
	public static void addCustomer(CustomerDTO data) {
//		list[listIndex] = data;
//		listIndex++;
		list.add(data);
	}
	
	public static Boolean checkValidName(String s) {
		try {
	        int d = Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
	
	public static Boolean checkValidAge(int age) {
		if(age < 0 || age > 150) {
			return false;
		}
		else return true;
	}
	

	public static String findCustomerName(int custId) {
//		for(int i = 0; i< listIndex; i++) {
//			if(list[i].getCustomerId() == custId) {
//				return list[i].getCustomerName();
//			}
//		}
//		print("Customer not found");
//		return null;
		return list.get(custId).getCustomerName();
	}
	
	public static CustomerDTO findByCustomerName(String name) {
//		for(int i = 0; i< listIndex; i++) {
//			if(list[i].getCustomerName().equals(name)) {
//				return list[i];
//			}
//		}
//		print("Customer not found");
//		return null;
		for(CustomerDTO cust: list) {
			if(cust.getCustomerName().equals(name)) {
				return cust;
			}
		}
		print("Customer not found");
		return null;
	}
	
	public static CustomerDTO getCustomer(int custId) {
//		for(int i = 0; i< listIndex; i++) {
//			if(list[i].getCustomerId() == custId) {
//				return list[i];
//			}
//		}
//		print("Customer not found");
//		return null;
		return list.get(custId);
	}
	
	public static void showMenu() {
		print("1. Create New Customer Data \n"+
			  "2. Assign a Bank Account to a Customer \n"+
		 	  "3. Display balance or interest earned by customer \n"+
		      "4. Sort Customer Data \n"+
		      "5. Persist Customer Data \n"+
		      "6. Show all Customer Data \n"+
		      "7. Search Customer by Name \n"+
		      "8. Exit \n");
	}
	
	// Controller -> Service Layer -> Data Access Object -> Storage (Oracle/MySQL)
	public static void main(String[] args) {
		CustomerServiceImp service = new CustomerServiceImp();
		Scanner sc = new Scanner(System.in);
		showMenu();

		while(sc.hasNext()) {
			int num = sc.nextInt();
			switch(num){
					case 1:
						print("Create New Customer Data \n"); 
						
						print("Please enter the Customer name \n");
						String newCustomerName = sc.next();
						while(checkValidName(newCustomerName)) {
							print("Please enter a Valid Customer name \n");
							newCustomerName = sc.next();
						}
						print("Please enter the Customer age \n");
						String newCustomerAge = sc.next();					
						while(!checkValidAge(Integer.parseInt(newCustomerAge))) {
							print("Please enter Valid Customer age \n");
							newCustomerAge = sc.next();
						}
						
						print("Please enter the Customer mobile number \n");
						long newCustomerMobilenumber = sc.nextInt();
							
						print("Please enter the Customer passport number \n");
						String newCustomerPassportnumber = sc.next();
					
						CustomerDTO newcust = new CustomerDTO(newCustomerName,Integer.parseInt(newCustomerAge),newCustomerMobilenumber,newCustomerPassportnumber);
						//addCustomer(newcust);
						service.createCustomer(newcust);
						
						print("New Customer Successfully Created  \n");
						print("Please select from the following options \n");
						showMenu();
						break;
						
					case 2: print("Assign a Bank Account to a Customer  \n"); 
					        print("Please enter the customer ID  \n"); 
							int custId = sc.nextInt();
					
							long accNum = (long) Math.floor(Math.random() *(999999999 - 10000000 + 1) + 10000000);
							long bsbcode = (long) Math.floor(Math.random() *(99999 - 100000 + 1) + 100000);
							String bankName = "ZYX-Bank";
							double balance = 1000;
							print("Hi "+ findCustomerName(custId));
							print("Please Select if you would like to opt for a Savings or "
									+ " a Fixed Deposit account  \n"); 
							print("1. Savings Acccount \n"+
							      "2. Fixed Deposit ");
							int accType = sc.nextInt();
							BankAccount acc = null;
							CustomerDTO cdata = getCustomer(custId);
							while(accType != 1 && accType != 2) {
								print("Please enter a valid account type ");
								accType = sc.nextInt();
							}
							
							if (accType == 1) {
								acc = new SavingsAccount(accNum,bsbcode,bankName,balance,LocalDate.now());
								cdata.getAccount().setAccountType("Savings Account");
								print("Savings Account is linked to the Customer with ID "+ custId);
							}
							else if (accType == 2) {
								acc = new FixedDeposit(accNum,bsbcode,bankName,balance,LocalDate.now());
								cdata.getAccount().setAccountType("Fixed Deposit");
								print("Fixed Deposit Account is linked to the Customer with ID "+ custId);
							}
													
							cdata.setAccount(acc);		
							print("Please select from the following options \n");
							showMenu();
							break;
							
					case 3: print("To Display balance or interest earned by customer \n"); 
							print("Please enter the customer ID  \n"); 
							custId = sc.nextInt();
							print("Hi "+ findCustomerName(custId));
							cdata = getCustomer(custId);
							BankAccount customerAccount = cdata.getAccount();
							print("Your account type is : "+ customerAccount.getAccountType()); 
							print("Interest rate : "+ customerAccount.returnInterest(customerAccount.getAccountType())); 
							print("Balance : "+ customerAccount.getBalance());
							
							print("Please select from the following options \n");
							showMenu();
							
					break;
					case 4: print("Sort Customer Data \n"); 
							print("Please select from the following options on how you would like to sort the data \n");
							print("1. Sort by Customer ID \n "
								+ "2. Sort by Customer Name");
							int option = sc.nextInt();
							
							while(option != 1 && option != 2) {
								print("Please enter a valid option \n");
								 option = sc.nextInt();
							}
							if(option == 1) {
								service.sortCustomersById();
							}
							else if(option == 2) {
								service.sortCustomersByName();
							}
								
					break;
					case 5: print("Persist Customer Data \n"); break;
					case 6: print("Show all Customer Data \n"); 
							print(service.retrieveCustomers().toString());
//							for(CustomerDTO cust: list) {
//								print(cust.toString());
//							}
					break;
					case 7: print("Search Customer by Name \n"); 
							print("Please Enter the Customer's Name \n");
							String custName = sc.next();
							CustomerDTO cd = findByCustomerName(custName);
							print(cd.toString());
					break;
					case 8: print("Exit \n"); break;
					
				}
		}
			

	}

}
