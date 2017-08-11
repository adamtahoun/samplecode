package com.example.demo;

/**
 * Created by z002p84 on 6/9/17.
 */
public class Venue {

    //            "venue": {
//        "name": "Firefly Music Festival",
//                "latitude": "39.189456",
//                "longitude": "-75.534845",
//                "city": "Dover",
//                "region": "DE",
//                "country": "United States"
//    }

   public String name;
    public Double latitude;
    public Double longitude;
    public String city;
    public String region;
    public String country;



    @Override
    public String toString() {
        return city;
    }
}
