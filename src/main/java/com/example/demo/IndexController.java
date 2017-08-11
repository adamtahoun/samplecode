package com.example.demo;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z002p84 on 6/9/17.
 */
 @RestController
   public class IndexController extends Exception implements ErrorController  {
       private static final String PATH = "/error";

     @RequestMapping(value = PATH)
     public ResponseEntity getError(){
         return new ResponseEntity(HttpStatus.NOT_FOUND);
     }

     @RequestMapping(value = "/error/invalidUsername")
     public String invalidUsername(){
         return "Please enter a valid username";
     }

     @RequestMapping(value = "/error/invalidPassword")
     public String invalidPassword(){
         return "Please enter a valid password";
     }


    @Override
       public String getErrorPath() {
           return PATH;
       }
   }
