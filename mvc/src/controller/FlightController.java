package controller;

import java.util.ArrayList;

import model.Flight;
import repository.Storage;

public class FlightController {
	static ArrayList<Flight> flights = new ArrayList<>();

	public FlightController() {

		flights.add(new Flight(1, "AirIndia", "Mumbai", "Chennai", 2, 1500));
		flights.add(new Flight(2, "JetAir", "Delhi", "Hyderabad", 50, 2000));
		flights.add(new Flight(3, "Indigo", "Pune", "Bangalore", 48, 1300));
		flights.add(new Flight(4, "AirIndia", "Bangalore", "Chennai", 52, 4000));
		flights.add(new Flight(5, "indigo", "Pune", "Chennai", 52, 5000));
	}

	public String[] ticketBooking(int flightNo, String pname, String email, int ticketCount, String username2) {
		Storage.flightbookings(flightNo, pname, email,ticketCount,username2);

		String arr[] = new String[4];
		for (Flight ft : flights) {
			if (ft.getflightNo() == flightNo) {
				
				ft.setCapacity(ft.getCapacity() - ticketCount); // update ticket count
				
				int totalcost = ft.getticketCost() * ticketCount;
				String tc = Integer.toString(totalcost);
				
				arr[0] = tc;
				arr[1] = ft.getflightName();
				arr[2]=ft.getflightLocation();
				arr[3]=ft.getflightDestination();// print
			}

		}

		return arr;
	}

	public ArrayList<Flight> viewFlight() {
		return flights;
	}

	public boolean checkTicketAvailability(int ticketCount, int flightNo) {
		for (Flight ft : flights) {
			if (ft.getflightNo() == flightNo) {
				if ((ticketCount <= ft.getCapacity())) {
					return true;
				} 
			}
		}
		return false;
	}
	 public  boolean isValidEmail(String email) {
	        // Note: This is a basic email validation, you might want to use a more comprehensive regex for production.
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        return email.matches(emailRegex);
	    }

	 public void getUserDetail(String username) {
		 System.out.println("enter");
		 Storage.retrieveData(username);
	 }
}
