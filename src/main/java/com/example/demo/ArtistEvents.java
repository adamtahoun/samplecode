package com.example.demo;

/**
 * Created by z002p84 on 6/9/17.
 */
public class ArtistEvents {

    public String city;
    public String date;

    public ArtistEvents(String city, String date){
        this.city = city;
        this.date = date;
    }

    public String getCity(){
        return city;
    }

    public String getDate(){
        return date;
    }
}
