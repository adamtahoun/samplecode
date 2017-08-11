package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z002p84 on 6/19/17.
 */
@RestController
public class InternalAPI {

    @Autowired
    UsersRepository repository;

    @RequestMapping("/login")
    public Users validateUser(String username, String password){

        Users result = repository.findByUsername(username);

        return result;

    }

    @RequestMapping("/register")
    public ResponseEntity<Users> registerUser(String username, String password){
        Users user = repository.save(new Users(username,password));
        System.out.println("Saved!");
        return ResponseEntity.ok().body(user);
    }



}
