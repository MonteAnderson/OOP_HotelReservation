package com.hotelres;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	    String file = "./HotelDatabase.csv";
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
                    List<Booking> bookings = Collections.emptyList();
                    System.out.printf("location: %s,\tname: %s,\ttime: %d,\trooms: %d,\tid: %d\n", location, name, time, rooms, id);
                    Hotel hotel = new Hotel(id, name, location, time, rooms, bookings);
                    hotelList.add(hotel);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            HotelListIterator hotelIter = new HotelListIterator(hotelList);
            while (hotelIter.hasNext()) {
                System.out.println(hotelIter.next().getId());
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
                    continue;
                }

                else if (userInput.equals("-book")){
                    continue;
                }

                else if (userInput.equals("-cancel")){
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

                else if (userInput.equals("-myBookings")){
                    //Display current list of users bookings
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
                //System.out.printf("Searching for %s ...", n);

            }
    }
}
