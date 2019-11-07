package com.example.comicstorespringbootmvn.publisher;


import com.example.comicstorespringbootmvn.user.User;
import com.example.comicstorespringbootmvn.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PublisherController {

    private final PublisherRepository repository;

    PublisherController(PublisherRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    @GetMapping("/publishers")
    List<Publisher> all() {
        System.out.println("Getting publisher...");
        return repository.findAll();
    }

    // Create a new Publisher
    @PostMapping("/publishers")
    public Publisher createNote(@Valid @RequestBody Publisher publisher) {
        return repository.save(publisher);
    }

}
