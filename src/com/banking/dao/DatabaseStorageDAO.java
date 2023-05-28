package com.banking.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking.dto.CustomerDTO;

public class DatabaseStorageDAO implements IDao {

	public Connection openConnection() {
		Connection con = null;
		try {
			// typer 4 driver is registered with Driver Manager.
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/emp", "root", "root");
			System.out.println("MySQL driver registered with DriverManager");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL suitable driver not found ");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void createCustomer(CustomerDTO customer) {
		int id = customer.getCustomerId();
		String name = customer.getCustomerName();
		int age = customer.getCustomerAge();
		//String dob = customer.getDOB();
		long mobilenumber = customer.getCustomerMobilenumber();
		String passportnumber = customer.getCustomerPassportnumber();
		
		Connection con = openConnection();
		
		try {
			String sql = "INSERT INTO CUSTOMERS(ID, NAME, AGE, MOBILENO, PASSPORTNO) VALUES(?,?,?,?,?)";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.setString(2, name);
			pstat.setInt(3, age);
			pstat.setLong(4, mobilenumber);
			pstat.setString(5, passportnumber);
			int n = pstat.executeUpdate();

			System.out.println("Number of rows inserted "+ n);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);
		System.out.println("Inside createCustomer in CustomerDAOImpl");
	}
	@Override
	public List<CustomerDTO> retrieveAllCustomers() {
		List<CustomerDTO> customers = new ArrayList<>();
		Connection con = openConnection();
		String sql = "SELECT * FROM customers;";
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				long mobileno = rs.getLong("MOBILENO");
				String passportno = rs.getString("PASSPORTNO");
				
				CustomerDTO customers1 = new CustomerDTO(name, age,mobileno,passportno);
				customers.add(customers1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);
		return customers;
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
