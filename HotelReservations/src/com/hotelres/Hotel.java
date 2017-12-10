package com.hotelres;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class Hotel {
    // Globies
    private int id;
    private String name;
    private String location;
    private int timeAvailable;
    private int roomsAvailable;
    private List<Booking> bookings;

    // Constructor? I hardly know 'er!
    public Hotel(int id, String name, String location, int timeAvailable, int roomsAvailable, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.timeAvailable = timeAvailable;
        this.roomsAvailable = roomsAvailable;
        this.bookings = bookings;
    }

    // Getties & Setties
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public int getTimeAvailable() {
        return timeAvailable;
    }
    public int getRoomsAvailable() {
        return roomsAvailable;
    }
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setId(int i){
        this.id = i;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setLocation(String l){
        this.location = l;
    }

    public void setRoomsAvailable(int r){
        this.roomsAvailable = r;
    }

    public void setTimeAvailable(int t){
        this.timeAvailable = t;
    }


    public void setBookings(List<Booking> b){
        this.bookings = b;
    }

    public Booking createBooking(int checkIn, int checkOut) {
        List<Booking> emptyBookings = new LinkedList<>();
        User user = new User(emptyBookings);
        return new Booking(id, user, this, checkIn, checkOut);
    }

    public void addBookings(Booking book) {

    }

    public void deleteBooking(Booking booking) {

    }

    protected List<Hotel> search(Map<String, String> criteria) {
        List<Hotel> hotelList = new LinkedList<>();
        return hotelList;
    }

    private boolean verifyCard(String number, String cvv, String expire) {
        //first check if the card is expired
        try {
            //parse for expiration month and year
            String[] data = expire.split("/");
            int expirationMonth = Integer.parseInt(data[0]);
            int expirationYear = Integer.parseInt(data[1]);

            //get current month and year
            int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            //check that card hasn't expired
            if (expirationYear < currentYear)
                return false;
            else if (expirationYear == currentYear && expirationMonth < currentMonth)
                return false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid expiration date in the format \'month/year\'");
            return false;
        }

        //check card number validity using Luhn Algorithm
        int sum = 0;
        boolean oddIndex = false;
        int cardLength = number.length();

        for (int x = cardLength - 1; x >= 0; x--) {
            int n = Integer.parseInt(number.substring(x, x + 1));
            if (oddIndex) {
                n = n * 2;
                if (n > 9)
                    n = (n % 10) + 1;
            }
            sum += n;
            oddIndex = !oddIndex;
        }
        return (sum % 10 == 0);
    }

    @Override
    public String toString(){
        return getName();
    }
}

