package com.hotelres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String file = "./HotelDatabase.csv";
	    String split = ",";
	    String line = "";
	    List<Hotel> hotelList = new LinkedList<>();
	    Boolean userQuit = false;
        Scanner reader = new Scanner(System.in);
        User user = new User(new LinkedList<Booking>());
	    try (BufferedReader br = new BufferedReader(new FileReader(file))){
	        while((line = br.readLine()) != null){
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

        } catch(IOException e) {
            e.printStackTrace();
        }

        HotelListIterator hotelIter = new HotelListIterator(hotelList);
	    while (hotelIter.hasNext()) {
	        System.out.println(hotelIter.next().getId());
        }
	    while (userQuit == false) {
                //Get User Input
                System.out.println("\nWelcome to the Hotel Reservation System! Type -help to see commands.");
                String n = reader.nextLine();

                if (n.equals("-help") || n.equals("-halp") || n.equals("--help")){
                    System.out.println("\nCommands are: -help | -quit | -search | -book | -cancel | -displayBookings | -version ");
                    continue;
                }

                if (n.equals("-search")){
                    continue;
                }

                if (n.equals("-book")){
                    continue;
                }

                if (n.equals("-cancel")){
                    continue;
                }

                if (n.equals("-displayBookings")){
                    continue;
                }

                if (n.equals("-quit")){
                    userQuit = true;
                    reader.close();
                    continue;
                }

                if (n.equals("-version")){
                    System.out.println("Version 0.8008135");
                    continue;
                }
                System.out.printf("Searching for %s ...", n);

            }
    }
}
