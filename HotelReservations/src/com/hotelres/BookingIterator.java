package com.hotelres;

import java.util.Iterator;
import java.util.List;

public class BookingIterator implements Iterator {

    private List<Booking> bookingList;
    private int index;

    public BookingIterator(List<Booking> bL){
        this.bookingList = bL;
        index = 0;
    }

    public boolean hasNext(){
        if ((index + 1) <=  bookingList.size()) {
            return true;
        }
        else
            return false;
    }

    public Booking next(){
        if (this.hasNext()){
            Booking B = bookingList.get(index);
            index++;
            return B;
        }
        else
            return null;
    }

}