package view;

import java.util.Scanner;

import controller.PassengerController;

public class PassengerView {
	public static void main(String[] args) {

		PassengerController pc = new PassengerController();
		FlightView fw = new FlightView();
		boolean setup = true;
		while (setup) {
			System.out.println(" Welcome to Flight Reservation \n 1.signup \n 2.Login \n 3.Exit");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {
			case 1: {
				String name;
				do {
					System.out.println("Enter Name (only letters allowed):");
					name = sc.next();
				} while (!pc.isValidName(name));

				// validate username
				String username;
				do {
					System.out.println("Enter Username (Alphabets and special character only):");
					username = sc.next();
				} while (!pc.isValidUsername(username));

				//validate password
				String password;
				do {
					System.out.println(
							"Enter Password (at least 8 characters, including at least one uppercase letter, one lowercase letter, and one digit):");
					password = sc.next();
				} while (!pc.isValidPassword(password));

				if (pc.userSignup(name, username, password)) {
					System.out.println("------------------------------------------");
					System.out.println("Successfully signed up");
					System.out.println("------------------------------------------");

					fw.view();
					fw.startFlight(username);

					
					break; // Break the outer loop if signup is successful
				} else {
					System.err.println("Sorry!! Failed to signup..!");
				}
			}
				while (true)
					; // Keep asking for user details until signup is successful

			case 2: {
				String username;
				do {
					System.out.println("Enter Username (Alphabets and special character only):");
					username = sc.next();
				} while (!pc.isValidUsername(username));

				String password;
				boolean a;

				do {
					System.out.println(
							"Enter Password (must have at least 8 characters, including uppercase, lowercase, and digit)");
					password = sc.next();

					if (pc.isValidPassword(password)) {
						a = false;
						// break; // Break the inner loop if the password is valid
					} else {
						a = true;
						System.out.println("Please enter a valid password");
					}
				} while (a); // Keep asking for the password until it's valid

				if (pc.userLogin(username, password)) {
					System.out.println("------------------------------------------");
					System.out.println("Successfully Login");
					System.out.println("------------------------------------------");
					fw.view();
					fw.startFlight(username);
				} else {
					System.err.println("Invalid Credentials");
				}
				break;

			}
			case 3: {
				setup = false;
				break;

			}

			}

		}

	}

}
