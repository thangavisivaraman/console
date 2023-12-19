package view;

import java.util.Scanner;

import controller.PassengerController;

	public class PassengerView {
		public static void main(String[] args) {

			PassengerController pc = new PassengerController();
			boolean setup = true;
			while (setup) {
				System.out.println(" Welcome to Flight Reservation \n 1.signup \n 2.Login \n 3.Exit");
				Scanner sc = new Scanner(System.in);
				int input = sc.nextInt();
				switch (input) {
				case 1: {
					System.out.println("Enter Name");
					String name = sc.next();
					System.out.println("Enter UserName");
					String username = sc.next();
					System.out.println("Enter Password");
					String password = sc.next();
					if (pc.userSignup(name, username, password)) {
						System.out.println("Successfully signup");

						FlightView fw = new FlightView();
						fw.flightView();

					}

					else
						System.err.println("Soryy!!Failed to signup..! ");
					break;
				}

				case 2: {
					System.out.println("Enter UserName");
					String username = sc.next();
					System.out.println("Enter Password");
					String password = sc.next();
					if (pc.userLogin(username, password)) {
						System.out.println("Successfully Login");
						FlightView fw = new FlightView();
						fw.flightView();
					}

					else
						System.err.println("Invalid Credentials");
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

