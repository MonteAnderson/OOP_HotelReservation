package com.hotelres;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

	    String file = "HotelDatabase.csv";
	    String split = ",";
	    String line = "";
	    Boolean userQuit = false;

        Scanner reader = new Scanner(System.in);
        User user = new User(new LinkedList<Booking>());
	    List<Hotel> hotelList = new LinkedList<>();


            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                    String[] h = line.split(split);
                    String location = h[0];
                    String name = h[1];
                    int time = Integer.parseInt(h[2]);
                    int rooms = Integer.parseInt(h[3]);
                    int id = name.hashCode();
                    List<Booking> bookings = new LinkedList<Booking>();
                    Hotel hotel = new Hotel(id, name, location, time, rooms, bookings);
                    hotelList.add(hotel);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            while (userQuit == false) {
                //Get User Input
                System.out.println("\nWelcome to the Hotel Reservation System! Type -help to see commands.");
                String userInput = reader.nextLine();

                if (userInput.equals("-help") || userInput.equals("-halp") || userInput.equals("--help")){
                    System.out.println("\nCommands are: -help | -quit | -search | -book | -cancel | -displayBookings | -version ");
                    continue;
                }

                else if (userInput.equals("-search")){
                    HotelListIterator hotelIter = new HotelListIterator(hotelList);

                    System.out.println("Enter a location: ");
                    String loc = reader.nextLine();

                    // Search for hotel
                    System.out.printf("Searching for \"%s\"...\n", loc);
                    List<Hotel> hotelsAvailable = user.searchHotel(hotelIter, loc);
                    if (hotelsAvailable.size() > 0) {
                        System.out.println("Hotels in available for booking:");
                        HotelListIterator availIter = new HotelListIterator(hotelsAvailable);
                        while (availIter.hasNext()) {
                            Hotel nextHotel = availIter.next();
                            Date nextTime = Date.from(Instant.ofEpochSecond(nextHotel.getTimeAvailable()));
                            System.out.printf("%s | %s | Rooms available: %d | Earliest check-in date: %s\n",
                                    nextHotel.getLocation(), nextHotel.getName(), nextHotel.getRoomsAvailable(), nextTime.toString());
                        }
                    }
                    else {
                        System.out.println("No hotels available for your query.");
                    }
                }

		        else if (userInput.equals("-book")){

                    //System.out.print("Enter the hotel name: ");
                    String hotelBookedName = "Nativ";

                    System.out.print("Input checkin date (MM/DD): ");
                    int checkInDate = reader.nextInt();
                    reader.nextLine();

                    System.out.print("Input checkout date (MM/DD): ");
                    int checkOutDate = reader.nextInt();
                    reader.nextLine();

                    System.out.print("Input Hotel: ");
                    String checkHotelName = reader.nextLine();

                    System.out.print("Please Input Card Number (No Dashes): ");
                    String cnum = reader.nextLine();

                    System.out.print("Please input cvv: ");
                    String cvv = reader.nextLine();

                    System.out.print("Please input expiration date (MM/YY): ");
                    String date = reader.nextLine();



                   List<Hotel> results = hotelList.stream()
                            .filter(h -> Objects.equals(h.getName(), checkHotelName))
                            .collect(Collectors.toList());


                    if(results.get(0).verifyCard(cnum, cvv, date)){
                        user.bookHotel(results.get(0), checkInDate, checkOutDate);
                    }
                    else {
                        System.out.print("Failed Verification");
                    }

                    continue;
                }

                else if (userInput.equals("-cancelBooking")){
                    System.out.print("Please Enter a hotel name: ");
                    String cancel = reader.nextLine();
                    List<Booking> results = user.getBookings().stream()
                            .filter(b -> Objects.equals(b.getHotel().getName(), cancel))
                            .collect(Collectors.toList());
                    user.cancelBooking(results.get(0));

                    continue;
                }

                else if (userInput.equals("-display")){
                    //Display all bookings
                    List<Booking> bookings = user.getBookings();
                        for (Booking b : bookings){
                            System.out.println(b);
                        }
                    continue;
                }

                else if (userInput.equals("-quit")){
                    userQuit = true;
                    reader.close();
                    continue;
                }

                else if (userInput.equals("-version")){
                    System.out.println("Version 0.8008135");
                    continue;
                }
                
                else {
                    System.out.println("ERROR: Unknown Command.");
                    continue;
                }

            }
    }
}
