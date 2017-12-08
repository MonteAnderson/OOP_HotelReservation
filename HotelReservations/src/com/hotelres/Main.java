package com.hotelres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String file = "HotelDatabase.csv";
	    String split = ",";
	    String line = "";
	    HotelListIterator hotels = new HotelListIterator();


	    try (BufferedReader br = new BufferedReader(new FileReader(file))){
	        while((line = br.readLine()) != null){
	            String[] h = line.split(split);
	            int id = h[0].hashCode();
	            String location = h[1];
                String name = h[2];
                int time = Integer.parseInt(h[3]);
                int rooms = Integer.parseInt(h[4]);
                List<Booking> bookings = Collections.emptyList();
                Hotel hotel = new Hotel(id, name, location, time, rooms, bookings);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
