package com.banking.service;

import java.util.Comparator;

import com.banking.dto.CustomerDTO;

public class CustomerComparator implements Comparator<CustomerDTO> {

	@Override
	public int compare(CustomerDTO o1, CustomerDTO o2) {
		if(o1.getCustomerId() < o2.getCustomerId()) {
			return 1;
		} else if(o1.getCustomerId() == o2.getCustomerId()) {
			return 0;
		} else {return -1;}
	}
}
