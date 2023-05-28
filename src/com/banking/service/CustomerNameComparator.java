package com.banking.service;

import java.util.Comparator;

import com.banking.dto.CustomerDTO;

public class CustomerNameComparator implements Comparator<CustomerDTO> {

	@Override
	public int compare(CustomerDTO o1, CustomerDTO o2) {
		int result = o1.getCustomerName().compareTo(o2.getCustomerName());
		return result;
		
	}

}
