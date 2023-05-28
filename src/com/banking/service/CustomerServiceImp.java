package com.banking.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.banking.dao.IDao;
import com.banking.dao.DatabaseStorageDAO;
import com.banking.dto.CustomerDTO;

public class CustomerServiceImp implements CustomerService {

	private IDao dao;
	
	public CustomerServiceImp() {
		dao = new DatabaseStorageDAO();
	}
	@Override
	public void createCustomer(CustomerDTO customer) {
		dao.createCustomer(customer);
	}

	@Override
	public String findCustomerName(int custId) {
		return dao.retrieveCustomer(custId).getCustomerName();
	}

	@Override
	public CustomerDTO findByCustomerName(String name) {
		return null;
	}

	@Override
	public CustomerDTO getCustomer(int custId) {
		// TODO Auto-generated method stub
		return dao.retrieveCustomer(custId);
	}
	@Override
	public List<CustomerDTO> retrieveCustomers() {
		return dao.retrieveAllCustomers();
		}
	
	public List<CustomerDTO> sortCustomersById(){
		Comparator<CustomerDTO> sortByID = new CustomerComparator();
		List<CustomerDTO> sortedIDs = retrieveCustomers();
		Collections.sort(sortedIDs, sortByID);
		return (List<CustomerDTO>) sortByID;
	}
	
	public List<CustomerDTO> sortCustomersByName(){
		Comparator<CustomerDTO> sortByName = new CustomerNameComparator();
		List<CustomerDTO> sortedNames = retrieveCustomers();
		Collections.sort(sortedNames, sortByName);
		return (List<CustomerDTO>) sortedNames;
	}

}
