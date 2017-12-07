package com.hotelres;

import java.util.Map;
import java.util.List;

public class Hotel {
    // Globies
    private int id;
    private String location;
    private List<Booking> bookings;

    public Hotel(int id, String location, List<Booking> bookings) {
        this.id = id;
        this.location = location;
        this.bookings = bookings;
    }

    // Getties & Setties
    public int getId() {
        return id;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public String getLocation() {
        return location;
    }


    public Booking createBooking(int checkIn, int checkOut) {
        User user = new User();
        Hotel hotel = new Hotel();
        Booking booking = new Booking(id, user, hotel, checkIn, checkOut);
    }

    public void addBookings(Booking book) {

    }

    public void deleteBooking(Booking booking) {

    }

    protected List<Hotel> search(Map<String, String> criteria) {

    }

    private boolean verifyCard(int number, int cvv, String expire) {
        return false;
    }
}