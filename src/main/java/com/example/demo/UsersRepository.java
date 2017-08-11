package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by z002p84 on 6/12/17.
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
    /*
    SELECT * FROM "Users" WHERE "username" == 'username'
     */
    Users findByUsername(String username);
}
