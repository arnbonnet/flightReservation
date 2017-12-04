package controller;

import java.util.Scanner;

import dao.FlightDAO;
import dao.ReservationDAO;
import model.Flight;
import model.Reservation;

public class ReservationController {

	public static void reservationMenu() {
		System.out.println("1) Cr�ation d'une r�servation");
		System.out.println("2) Voir les r�servations d'un vol");
		System.out.println("3) Annuler une r�servation");
		System.out.println("4) Voir toutes les r�servation d'une personne");
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		switch(input) {
		case 1 :
			ReservationCreationSystem();
			break;
		}
		
	}

	private static void ReservationCreationSystem() {
		System.out.println("Veuillez renseigner le num�ro du vol que vous voulez r�server");
		Scanner scanner = new Scanner(System.in);
		String flightNumber = scanner.nextLine();
		
		FlightDAO flightDAO = new FlightDAO();
		Flight flight = null;
		flight = flightDAO.getFlightByNumber(flightNumber);
		
		if(flight == null) {
			System.out.println("Ce vol n'existe pas ");
			ReservationCreationSystem();
		} else {
			System.out.println("Veuillez renseigner votre Nom");
			Scanner scanner2 = new Scanner(System.in);
			String lastName = scanner2.nextLine();
			
			System.out.println("Veuillez renseigner votre Pr�nom");
			Scanner scanner3 = new Scanner(System.in);
			String firstName = scanner3.nextLine();
			
			System.out.println("Veuillez renseigner votre age");
			Scanner scanner4 = new Scanner(System.in);
			Integer age = scanner4.nextInt();
			
			Reservation reservation = new Reservation();
			reservation.setAge(age);
			reservation.setFirstName(firstName);
			reservation.setLastName(lastName);
			reservation.setFlight(flight);
			
			ReservationDAO reservationDAO = new ReservationDAO();
			reservationDAO.persist(reservation);
			
			
			
			//reservation.setReservationNumber(reservationNumber);
			
		}
		
	}

}
