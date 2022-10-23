package com.junaid.databaseopertation;

import java.sql.*;
import java.util.*;

public class SendData {

	static final String DB_URL = "jdbc:mysql://localhost/mytest";
	static final String USER = "root";
	static final String PASS = "";
	static String phone_no = "";
	static String name = "";

	public SendData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("please Enter the Name                   :  ");
		name = sc.next();
		System.out.println("Please Enter the phone number to contact:  ");
		phone_no = sc.next();
		sc.close();

	}

	public static void main(String[] args)throws Exception
	{
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = (PreparedStatement) conn.createStatement();
				) {		      
			// Execute a query
			System.out.println("Inserting records into the table...");
			new SendData();
			String sql = "insert into employees  values (?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, phone_no);
			stmt.executeUpdate();
			System.out.println("Inserted records into the table...");   	  
		} catch (SQLException e) {
			e.printStackTrace();
		} 


	}

}
