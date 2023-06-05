package com.banking.dao;

import java.io.File;
import java.util.List;

import com.banking.dto.CustomerDTO;

public class FileSystemDAO implements IDao {
	private String filename;
	File file = new File(filename);
	

	@Override
	public void createCustomer(CustomerDTO customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<CustomerDTO> retrieveAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAllCustomers() {
		// TODO Auto-generated method stub
		
	}

}
