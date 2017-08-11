package com.example.demo;

/**
 * Created by z002p84 on 6/9/17.
 */
public class Event {

//    "id": "13773939",
//            "artist_id": "140",
//            "url": "http://www.bandsintown.com/event/13773939?app_id=adam_id&artist=Weezer&came_from=67",
//            "on_sale_datetime": "",
//            "datetime": "2017-06-16T19:00:00",
//            "venue": {
//        "name": "Firefly Music Festival",
//                "latitude": "39.189456",
//                "longitude": "-75.534845",
//                "city": "Dover",
//                "region": "DE",
//                "country": "United States"
//    }


    public String id;
    public String artist_id;
    public String url;
    public String on_sale_dateime;
    public String datetime;
    public Venue venue;

    @Override
    public String toString() {
        return "Event{" +
                "datetime='" + datetime + '\'' +
                ", venue=" + venue +
                '}';
    }
}
