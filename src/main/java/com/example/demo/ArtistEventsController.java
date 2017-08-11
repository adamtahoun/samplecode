package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.spark.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ArtistEventsController {

    @Autowired
    UsersRepository repository;

    @RequestMapping("/artist-events/{artist_name}")
    public ArtistEvents[] artistEvents(HttpServletResponse http_response, @PathVariable String artist_name, String user_name, String pass) throws IOException {

        if(artist_name == null || (user_name == null || pass == null))
            http_response.sendRedirect("/error");

        Users result = repository.findByUsername(user_name);

        if(result == null){
            System.out.println("Invalid Username");
            http_response.sendRedirect("/error/invalidUsername");
        }
        else if(!result.getPassword().contentEquals(pass)){
            System.out.println("Invalid Password");
            http_response.sendRedirect("/error/invalidPassword");
        }
        else{
            System.out.println("Valid Username and Password");
        }


        RestTemplate restTemplate = new RestTemplate();

        System.out.println(user_name + ' ' + pass);

        ResponseEntity<Event[]> response = restTemplate.getForEntity(
                "https://rest.bandsintown.com/artists/" + artist_name + "/events?app_id=adam_id",Event[].class);

        Event[] res = response.getBody();
        ArtistEvents[] artistevents = new ArtistEvents[res.length];
        for (int i = 0; i < res.length; i++) {
            // 2017-06-16
            String[] parts = res[i].datetime.split("T");
            String[] dateArr = parts[0].split("-");
            String date = dateArr[1] + "/" + dateArr[2] + "/" + dateArr[0];
            ArtistEvents ae = new ArtistEvents(res[i].venue.city, date);
            artistevents[i] = ae;
        }

        return artistevents;

    }

    @RequestMapping("/save")
    public String process(@RequestParam String user_name, @RequestParam String password) {
        repository.save(new Users(user_name,password));
        return "Done";
    }
}

