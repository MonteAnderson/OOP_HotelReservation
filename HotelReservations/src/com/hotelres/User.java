package com.hotelres;

import javax.swing.text.html.ListView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class User {
    private List<Booking> bookings;

    public User(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void bookHotel(Hotel hotel, int checkIn, int checkOut) {
        int id = (int) Math.random() * 1000000;
        Booking b = new Booking(id, this, hotel, checkIn, checkOut);
        addBooking(b);
        hotel.addBookings(b);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void cancelBooking(Booking booking) {
        BookingIterator iterator = new BookingIterator(bookings);
        while (iterator.hasNext()) {
            Booking b = iterator.next();
            if (booking.getID() == b.getID())
                bookings.remove(b);
        }
    }

    public List<Hotel> searchHotel(HotelListIterator hotelIter, String location) {
        List<Hotel> hotelList = new LinkedList<>();
        while (hotelIter.hasNext()) {
            Hotel nextHotel = hotelIter.next();
            if (Pattern.matches("(?i)^"+location+"[a-zA-z\\s]*", nextHotel.getLocation())) {
                hotelList.add(nextHotel);
            }
        }
        System.out.println(hotelList);
        return hotelList;
    }
}