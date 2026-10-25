package codeAlpa_HotelReservationSystem;
import java.util.Scanner;
public class HotelReservationSystem {
	

	    static Scanner sc = new Scanner(System.in);

	    static String[] roomTypes = {"Single", "Double", "Deluxe"};
	    static int[] roomPrices = {1000, 2000, 3500};
	    static boolean[] roomBooked = {false, false, false};

	    static String[] guestNames = new String[3];
	    static String[] guestContacts = new String[3];
	    static int[] nightsBooked = new int[3];

	    public static void main(String[] args) {

	        int choice = 0;

	        do {
	            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
	            System.out.println("1. View Rooms");
	            System.out.println("2. Book a Room");
	            System.out.println("3. View Booking Details");
	            System.out.println("4. Cancel Booking");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            if (!sc.hasNextInt()) {
	                System.out.println("Please enter a valid number.");
	                sc.nextLine();
	                continue;
	            }

	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {

	                case 1:
	                    viewRooms();
	                    break;

	                case 2:
	                    bookRoom();
	                    break;

	                case 3:
	                    viewBooking();
	                    break;

	                case 4:
	                    cancelBooking();
	                    break;

	                case 5:
	                    System.out.println("Thank you for using the Hotel Reservation System!");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }

	        } while (choice != 5);

	        sc.close();
	    }

	    static void viewRooms() {

	        System.out.println("\n----- AVAILABLE ROOMS -----");

	        for (int i = 0; i < roomTypes.length; i++) {

	            System.out.println(
	                "Room " + (i + 1)
	                + " | Type: " + roomTypes[i]
	                + " | Price: Rs." + roomPrices[i]
	                + " per night"
	                + " | Status: "
	                + (roomBooked[i] ? "Booked" : "Available")
	            );
	        }
	    }

	    static void bookRoom() {

	        System.out.println("\n----- BOOK A ROOM -----");
	        viewRooms();

	        System.out.print("Enter room number (1-3): ");

	        if (!sc.hasNextInt()) {
	            System.out.println("Invalid room number.");
	            sc.nextLine();
	            return;
	        }

	        int room = sc.nextInt();
	        sc.nextLine();

	        if (room < 1 || room > 3) {
	            System.out.println("Invalid room number.");
	            return;
	        }

	        int index = room - 1;

	        if (roomBooked[index]) {
	            System.out.println("This room is already booked.");
	            return;
	        }

	        System.out.print("Enter guest name: ");
	        String name = sc.nextLine().trim();

	        if (name.isEmpty()) {
	            System.out.println("Guest name cannot be empty.");
	            return;
	        }

	        System.out.print("Enter contact number: ");
	        String contact = sc.nextLine().trim();

	        if (contact.isEmpty()) {
	            System.out.println("Contact number cannot be empty.");
	            return;
	        }

	        System.out.print("Enter number of nights: ");

	        if (!sc.hasNextInt()) {
	            System.out.println("Please enter a valid number.");
	            sc.nextLine();
	            return;
	        }

	        int nights = sc.nextInt();
	        sc.nextLine();

	        if (nights <= 0) {
	            System.out.println("Number of nights must be greater than zero.");
	            return;
	        }

	        roomBooked[index] = true;
	        guestNames[index] = name;
	        guestContacts[index] = contact;
	        nightsBooked[index] = nights;

	        int totalCost = roomPrices[index] * nights;

	        System.out.println("\n===== BOOKING SUCCESSFUL =====");
	        System.out.println("Guest Name: " + name);
	        System.out.println("Contact Number: " + contact);
	        System.out.println("Room Number: " + room);
	        System.out.println("Room Type: " + roomTypes[index]);
	        System.out.println("Number of Nights: " + nights);
	        System.out.println("Price Per Night: Rs." + roomPrices[index]);
	        System.out.println("Total Cost: Rs." + totalCost);
	    }

	    static void viewBooking() {

	        System.out.println("\n----- BOOKING DETAILS -----");

	        boolean found = false;

	        for (int i = 0; i < roomTypes.length; i++) {

	            if (roomBooked[i]) {

	                found = true;

	                System.out.println("\nRoom Number: " + (i + 1));
	                System.out.println("Guest Name: " + guestNames[i]);
	                System.out.println("Contact Number: " + guestContacts[i]);
	                System.out.println("Room Type: " + roomTypes[i]);
	                System.out.println("Number of Nights: " + nightsBooked[i]);
	                System.out.println("Price Per Night: Rs." + roomPrices[i]);
	                System.out.println(
	                    "Total Cost: Rs."
	                    + (roomPrices[i] * nightsBooked[i])
	                );
	            }
	        }

	        if (!found) {
	            System.out.println("No bookings found.");
	        }
	    }

	    static void cancelBooking() {

	        System.out.println("\n----- CANCEL BOOKING -----");
	        viewRooms();

	        System.out.print("Enter room number to cancel (1-3): ");

	        if (!sc.hasNextInt()) {
	            System.out.println("Invalid room number.");
	            sc.nextLine();
	            return;
	        }

	        int room = sc.nextInt();
	        sc.nextLine();

	        if (room < 1 || room > 3) {
	            System.out.println("Invalid room number.");
	            return;
	        }

	        int index = room - 1;

	        if (!roomBooked[index]) {
	            System.out.println("This room has no booking.");
	            return;
	        }

	        roomBooked[index] = false;
	        guestNames[index] = null;
	        guestContacts[index] = null;
	        nightsBooked[index] = 0;

	        System.out.println("Booking cancelled successfully!");
	    }
	}


