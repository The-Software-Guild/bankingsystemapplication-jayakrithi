package com.banking.service;
import java.util.List;

import com.banking.dto.CustomerDTO;

public interface CustomerService {
	void createCustomer(CustomerDTO customer); 
	String findCustomerName(int custId);
	CustomerDTO findByCustomerName(String name);
	CustomerDTO getCustomer(int custId);
	List<CustomerDTO> retrieveCustomers();
}
