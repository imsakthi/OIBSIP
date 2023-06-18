package onlinereservationsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReservationSystem {
    private Map<String, Boolean> seats;

    public ReservationSystem(int numberOfSeats) {
        seats = new HashMap<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.put("Seat" + i, false);
        }
    }

    public synchronized boolean reserveSeat(String seatName) {
        if (seats.containsKey(seatName) && !seats.get(seatName)) {
            seats.put(seatName, true);
            return true;
        }
        return false;
    }

    public synchronized void printAvailableSeats() {
        System.out.println("Available Seats:");
        for (Map.Entry<String, Boolean> entry : seats.entrySet()) {
            if (!entry.getValue()) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        int numberOfSeats = 10;
        ReservationSystem reservationSystem = new ReservationSystem(numberOfSeats);

        Scanner scanner = new Scanner(System.in);
        String seatName;

        while (true) {
            System.out.println("1. Reserve a seat");
            System.out.println("2. View available seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the seat name: ");
                    seatName = scanner.nextLine();
                    boolean success = reservationSystem.reserveSeat(seatName);
                    if (success) {
                        System.out.println("Seat " + seatName + " reserved successfully.");
                    } else {
                        System.out.println("Seat " + seatName + " is not available.");
                    }
                    break;
                case 2:
                    reservationSystem.printAvailableSeats();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

