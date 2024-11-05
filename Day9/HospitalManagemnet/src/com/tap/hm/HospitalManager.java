package com.tap.hm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Room {
    private String roomNumber;
    private String roomType; // e.g., Single, Double, Suite
    private boolean isAvailable;

    public Room(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true; // Rooms are available when created
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public abstract String getDetails();
}

class SingleRoom extends Room {
    public SingleRoom(String roomNumber) {
        super(roomNumber, "Single");
    }

    @Override
    public String getDetails() {
        return "Room Number: " + getRoomNumber() + ", Type: " + getRoomType() + ", Available: " + isAvailable();
    }
}

class DoubleRoom extends Room {
    public DoubleRoom(String roomNumber) {
        super(roomNumber, "Double");
    }

    @Override
    public String getDetails() {
        return "Room Number: " + getRoomNumber() + ", Type: " + getRoomType() + ", Available: " + isAvailable();
    }
}

class HostelManagement {
    private Map<String, Room> rooms = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addRoom(String type, String roomNumber) {
        Room room;
        if ("Single".equalsIgnoreCase(type)) {
            room = new SingleRoom(roomNumber);
        } else {
            room = new DoubleRoom(roomNumber);
        }
        rooms.put(roomNumber, room);
        System.out.println("Room added successfully.");
    }

    public void bookRoom(String roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailability(false);
            System.out.println("Room " + roomNumber + " booked successfully.");
        } else {
            System.out.println("Room not available or does not exist.");
        }
    }

    public void checkOutRoom(String roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null && !room.isAvailable()) {
            room.setAvailability(true);
            System.out.println("Room " + roomNumber + " checked out successfully.");
        } else {
            System.out.println("Room not booked or does not exist.");
        }
    }

    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : rooms.values()) {
                System.out.println(room.getDetails());
            }
        }
    }

    public static void main(String[] args) {
        HostelManagement hostel = new HostelManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option: \n1. Add Room \n2. Book Room \n3. Check Out Room \n4. Display Rooms \n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (Single/Double): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    String roomNumber = scanner.nextLine();
                    hostel.addRoom(type, roomNumber);
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    hostel.bookRoom(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter room number to check out: ");
                    hostel.checkOutRoom(scanner.nextLine());
                    break;
                case 4:
                    hostel.displayRooms();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
