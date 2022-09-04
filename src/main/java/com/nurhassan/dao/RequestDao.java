package com.nurhassan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nurhassan.obj.Request;

public class RequestDao {
	private String dataBaseURL = "jdbc:postgresql://localhost:5432/information";
	private String databaseUserName = "postgres";
	private String databasePassword = "NurHassan@2000";
	
	public boolean storeContactData(Request contactInfo)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dataBaseURL, databaseUserName, databasePassword);
			String query = "insert into contactinfo values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, contactInfo.getName());
			statement.setString(2, contactInfo.getEmail());
			statement.setString(3, contactInfo.getMessage());
			statement.setBoolean(4, contactInfo.isStatus());
			
			if(statement.executeUpdate()!=0)
			{
				connection.close();
				return true;
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	public List<Request> fetchContactData()
	{	
		List<Request> contactInfoList = new ArrayList<>();
		
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dataBaseURL, databaseUserName, databasePassword);
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery("select * from contactinfo");
			
			while(result.next())
			{	
				Request requestData = new Request();
				
				requestData.setName(result.getString(1));
				requestData.setEmail(result.getString(2));
				requestData.setMessage(result.getString(3));
				requestData.setStatus(result.getBoolean(4));
				requestData.setRequestId(result.getInt(5));
				
				contactInfoList.add(requestData);
			}
			connection.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return contactInfoList;
	}
	public boolean updateData(int requestId)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dataBaseURL, databaseUserName, databasePassword);
			String getStatusQuery = "select status from contactinfo where id =?";
			PreparedStatement getStatus = connection.prepareStatement(getStatusQuery);
			getStatus.setInt(1, requestId);
			
			ResultSet statusResult = getStatus.executeQuery();
			
			String updateStatusQuery = "update contactinfo set status = ? where id = ?";
			PreparedStatement setStatus = connection.prepareStatement(updateStatusQuery);
			while(statusResult.next())
			{
				if(statusResult.getBoolean(1))
				{
					 setStatus.setBoolean(1, false);
					 setStatus.setInt(2, requestId);
				}else
				{
					 setStatus.setBoolean(1, true);
					 setStatus.setInt(2, requestId);
				}
				
			}
			
			setStatus.executeUpdate();
			connection.close();
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

}
