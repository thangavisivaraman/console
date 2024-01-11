package controller;

import java.util.ArrayList;

import model.Passenger;
import repository.Storage;

	

	public class PassengerController {
		
		//private  ArrayList<Passenger> userregister = new ArrayList<>();

	//	Passenger p;  //model

		public boolean userSignup(String name,  String username, String password) {
             Storage.signup(name,username,password);
			//userregister.add(new Passenger(name,  username, password));
			return true;

		}

		public boolean userLogin(String username, String password) {
			
			boolean retrieveAllData = Storage.retrieveAllData(username,password);
			if(retrieveAllData) {
				return true;
			}
			else {
				return false;
			}
//			boolean check = false;   
//			for (Passenger pk : userregister)
//			{
//				if (pk.getUsername().equals(username) && pk.getPassword().equals(password)) {
//					check = true;
//				}
//
//			}
//
//			return check;

		}
		

		public Boolean isValidPassword(String password) {
			// TODO Auto-generated method stub
			if (password.length() >= 8 &&
				    password.matches(".*[a-z].*") &&
				    password.matches(".*[A-Z].*") &&
				    password.matches(".*\\d.*")) {
				    return true;
				}

			//this.view.onerror("Password must have at least 8 characters, including uppercase, lowercase, and digit");
			return false;
		}
		 public  boolean isValidName(String name) {
		        return name.matches("[a-zA-Z]+");
		    }

		    // Validate Username: Allow only alphanumeric characters
		 public boolean isValidUsername(String username) {
			    // This regular expression allows only alphabets (letters) and special characters
			    return username.matches("^[a-zA-Z!@#$%^&*(),.?\":{}|<>]+$");
			}


		  
	}

