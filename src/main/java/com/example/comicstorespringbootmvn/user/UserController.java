package com.example.comicstorespringbootmvn.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    @GetMapping("/users")
    List<User> all() {
        System.out.println("Getting users...");
        return repository.findAll();
    }

}
