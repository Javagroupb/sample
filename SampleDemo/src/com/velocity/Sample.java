package com.velocity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample {
	public static void main(String[] args) throws Exception{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement2=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase55", "root","root");
			preparedStatement=connection.prepareStatement("insert into users(firstname,lastname,address,city,salary)values(?,?,?,?,?)");
			preparedStatement2=connection.prepareStatement("insert into users(firstname,lastname,address,city,salary)values(?,?,?,?,?)");

			preparedStatement.setString(1, "Irfan");
			preparedStatement.setString(2, "Shaikh");
			preparedStatement.setString(3, "katraj");
			preparedStatement.setString(4, "Pune");
			preparedStatement.setString(5, "50000");
			preparedStatement2.setString(1, "Ajay");
			preparedStatement2.setString(2, "Pawar");
			preparedStatement2.setString(3, "Andheri");
			preparedStatement2.setString(4, "Mumbai");
			preparedStatement2.setString(5, "60000");
			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
			System.out.println("Insertion with Prepared Statement done successfully...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			preparedStatement2.close();
		}


	}
}
