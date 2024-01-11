package view;

import java.util.*;

import controller.FlightController;
import model.Flight;

public class FlightView {
	FlightController s1 = new FlightController();

	public void startFlight(String username2) {

		boolean setup1 = true;
		while (setup1) {
			// s1.viewFlight();
			System.out.println("flight booking\n 1. book ticket\n 2.View booked ticket \n 3.exit");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {
			case 1: {
				System.out.println("Enter flightNo");
				int flightNo = sc.nextInt();
				System.out.println("Enter PassengerName");
				String passengerName = sc.next();
				String email;
				do {
					System.out.println("Enter Email(enter the correct format):");
					email = sc.next();
				} while (!s1.isValidEmail(email));

				String[] arr = null;
				do {
					System.out.println("Enter Tickets");
					int ticketCount = sc.nextInt();

					if (ticketCount > 0 && s1.checkTicketAvailability(ticketCount, flightNo)) {

						arr = s1.ticketBooking(flightNo, passengerName, email, ticketCount, username2);
						break; // Exit the loop if a valid ticket count is provided
					} else {
						System.out.println("Please enter a valid number of tickets (should be greater than 0).");
					}
				} while (true); // Repeat until a valid input is provided
				System.out.println("------------------------------------------");
				System.out.println("FligtName:" + arr[1]);
				System.out.println("TotalCost:" + arr[0]);
				System.out.println("From Location:" + arr[2]);
				System.out.println("Destination:" + arr[3]);
				System.out.println("Booked Successfully Happy Journey");
				System.out.println("------------------------------------------");
				view();
				break;
			}
			case 2:
				System.out.println("Enter the username");
				String username = sc.next();
				s1.getUserDetail(username);
                break;
			case 3: {
				setup1 = false;
				break;

			}

			}
		}
	}

	public void view() {
		ArrayList<Flight> viewFlight = s1.viewFlight();
		for (Flight ft : viewFlight)// flight model
		{
			System.out.println(ft.getflightNo() + " " + ft.getflightName() + " " + ft.getflightLocation() + " to" + " "
					+ ft.getflightDestination() + " " + ft.getCapacity() + " " + ft.getticketCost());
		}
		System.out.println("----------------------------------------");
	}
}
