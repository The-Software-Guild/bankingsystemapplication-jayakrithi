package com.banking.dao;
import java.util.List;

import com.banking.dto.CustomerDTO;

public interface IDao {
	void createCustomer(CustomerDTO customer);
	List<CustomerDTO> retrieveAllCustomers();
	CustomerDTO retrieveCustomer(int id);
	CustomerDTO retrieveCustomerByName(String name);
	void saveAllCustomers();
}
