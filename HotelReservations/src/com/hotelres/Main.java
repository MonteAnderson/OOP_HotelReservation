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
	//Get User Input
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Search: ");
        String n = reader.nextLine();
        System.out.printf("Searching for %s ...", n);
        reader.close();
    }
}
