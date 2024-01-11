package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Storage {

	
	public static void signup(String name, String username, String password2) {
	    String url = "jdbc:mysql://localhost:3306/ticketbooking";
	    String user = "thangavi";
	    String password = "Thangavi@123";

	    // JDBC variables for opening, closing, and managing connection
	    try (Connection connection = DriverManager.getConnection(url, user, password)) {

	        // Example: INSERT query
	        String insertQuery = "INSERT INTO sign_up(name,username,password) VALUES (?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            // Set values for each parameter in the PreparedStatement
	          //  preparedStatement.setString(1, "value1");
	        	
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, username);
	            preparedStatement.setString(3, password2);

	            // Execute the INSERT operation
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Insert successful!");
	            } else {
	                System.out.println("Insert failed!");
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void flightbookings(int flightNo, String pname, String email, int ticketCount, String username2) {
		 String url = "jdbc:mysql://localhost:3306/ticketbooking";
		    String user = "thangavi";
		    String password = "Thangavi@123";

		    // JDBC variables for opening, closing, and managing connection
		    try (Connection connection = DriverManager.getConnection(url, user, password)) {

		        // Example: INSERT query
		        String insertQuery = "INSERT INTO bookings VALUES (?, ?, ?,?,?)";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
		            // Set values for each parameter in the PreparedStatement
		          //  preparedStatement.setString(1, "value1");
		        	
		            preparedStatement.setInt(1, flightNo);
		            preparedStatement.setString(2, pname);
		            preparedStatement.setString(3, email);
		            preparedStatement.setInt(4, ticketCount);
		            preparedStatement.setString(5, username2);
		            // Execute the INSERT operation
		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                System.out.println("Insert successful!");
		            } else {
		                System.out.println("Insert failed!");
		            }
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}
	public static boolean retrieveAllData(String username, String password2) {
        String url = "jdbc:mysql://localhost:3306/ticketbooking";
        String user = "thangavi";
        String password = "Thangavi@123";

        // JDBC variables for opening, closing, and managing connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Example: SELECT query to retrieve all data
            String selectQuery = "SELECT * FROM sign_up";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Process the result set
                while (resultSet.next()) {
                   // String retrievedName = resultSet.getString("name");
                    String retrievedUsername = resultSet.getString("username");
                    String retrievedPassword = resultSet.getString("password");
                    
                    if(retrievedUsername.equals(username)&&retrievedPassword.equals(password2)) {
                    	return true;
                    }
                    

                    // Process the retrieved data as needed
                    //System.out.println("Name: " + retrievedName + ", Username: " + retrievedUsername + ", Password: " + retrievedPassword);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }
	public static void retrieveData(String username2) {
	    String url = "jdbc:mysql://localhost:3306/ticketbooking";
	    String user = "thangavi";
	    String password = "Thangavi@123";

	    // JDBC variables for opening, closing, and managing connection
	    try (Connection connection = DriverManager.getConnection(url, user, password)) {

	        // Example: SELECT query to retrieve all data
	    	String selectQuery = "SELECT bookings.flight_no, bookings.passenger_name, bookings.email_id, bookings.no_of_tickets, sign_up.username " +
                    "FROM bookings " +
                    "JOIN sign_up ON bookings.username = sign_up.username " +
                    "WHERE sign_up.username = ?";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setString(1, username2);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                // Process the result set
	                while (resultSet.next()) {
	                    int flightNo = resultSet.getInt("flight_no");
	                    String passengerName = resultSet.getString("passenger_name");
	                    String emailId = resultSet.getString("email_id");
	                    int noOfTickets = resultSet.getInt("no_of_tickets");
	                    String userName = resultSet.getString("username");

	                    // Process the retrieved data as needed
	                    System.out.println("Flight No: " + flightNo +
	                                       ", Passenger Name: " + passengerName +
	                                       ", Email ID: " + emailId +
	                                       ", No of Tickets: " + noOfTickets +
	                                       ", Username: " + userName);
	                }
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
}
	

