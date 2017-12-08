package com.hotelres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    String file = "HotelDatabase.csv";
	    String split = ",";
	    String line = "";
	    HotelListIterator hotels = new HotelListIterator();

	    try (BufferedReader br = new BufferedReader(new FileReader(file))){
	        while((line = br.readLine()) != null){
	            String[] h = line.split(split);
	            String location = h[0];
                String name = h[1];
                String time = h[2];
                String rooms = h[3];
                int id = String.hashCode(name);
                Hotel hotel = new Hotel(id, name, location, time, rooms);


            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
