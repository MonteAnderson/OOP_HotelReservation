package com.hotelres;

import java.util.Date;

public class Booking{

    private int id;
    private User user;
    private Hotel hotel;
    private int checkIn;
    private int checkOut;

    public Booking(int id, User user, Hotel hotel, int checkIn, int checkOut) {
        this.id = id;
        this.user = user;
        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getID() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public int getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(int newCheckIn) {
        this.checkIn = newCheckIn;
    }

    public int getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(int newCheckOut) {
        this.checkOut = newCheckOut;
    }
}