package com.nurhassan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nurhassan.obj.User;

public class UserDao {

	private String dataBaseURL = "jdbc:postgresql://localhost:5432/information";
	private String databaseUserName = "postgres";
	private String databasePassword = "NurHassan@2000";

	public boolean checkCardentials(User userData) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dataBaseURL, databaseUserName, databasePassword);
			String query = "select * from admin where username = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, userData.getUserName());
			statement.setString(2, userData.getPassword());
			
			ResultSet result = statement.executeQuery();
			System.out.println(result);
			if (result.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error in userdao"+e);
		}

		return false;
	}
}
