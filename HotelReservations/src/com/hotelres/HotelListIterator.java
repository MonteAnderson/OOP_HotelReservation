package com.hotelres;

import java.util.Iterator;
import java.util.List;

public class HotelListIterator implements Iterator {

    private List<Hotel> hotelList;
    private int index;

    public HotelListIterator(List<Hotel> hL){
        this.hotelList = hL;
        index = 0;
    }

    public boolean hasNext(){
        if ((index + 1) <= hotelList.size()){
            return true;
        }
        else
            return false;
    }

    public Hotel next(){
        if (this.hasNext()){
            Hotel H = hotelList.get(index);
            index++;
            return H;
        }
        else
            return null;
    }
}
