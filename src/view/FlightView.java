package view;

import java.util.*;

import controller.FlightController;

	public class FlightView {
		FlightController s1 = new FlightController ();
		public void flightView()
		{
	        
			boolean setup1 = true;
		    while (setup1) {
		    	 s1.viewFlight();
			System.out.println("flight booking\n 1. book ticket \n 2.exit");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {
			case 1: {
				System.out.println("Enter flightNo");
				int flightNo = sc.nextInt();
				System.out.println("Enter PassengerName");
				String  passengerName = sc.next();
				System.out.println("Enter Emailid");
				 String email = sc.next();
				System.out.println("Enter Tickets");
				int ticketCount =sc.nextInt();
				String[] arr=s1.ticketBooking(flightNo,passengerName,email,ticketCount);

					System.out.println("FligtName:"+arr[1]);
					System.out.println("TotalCost:"+arr[0]);
					System.out.println("Booked Successfully Happy Journey");
				break;
			}
	       case 2: {
				setup1 = false;
				break;

			}


		}
	}
		}
	}


