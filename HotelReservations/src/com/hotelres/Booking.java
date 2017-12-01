package com.hotelres;

import java.util.Date;

public class Booking{

    private int id;
    private User user;
    private Hotel hotel;
    private Date checkIn;
    private Date checkOut;

    public Booking(int id, User user, Hotel hotel, Date checkIn, Date checkout) {
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

    public Date getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(Date newCheckIn) {
        this.checkIn = newCheckIn;
    }

    public Date getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(Date newCheckOut) {
        this.checkOut = newCheckOut;
    }
}