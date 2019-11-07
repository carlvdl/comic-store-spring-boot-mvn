package com.example.comicstorespringbootmvn.publisher;

import com.example.comicstorespringbootmvn.user.IUserService;
import com.example.comicstorespringbootmvn.user.User;
import com.example.comicstorespringbootmvn.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService implements IPublisherService {


    @Autowired
    private PublisherRepository repository;

    @Override
    public List<Publisher> findAll() {
        return (List<Publisher>) repository.findAll();
    }

    @Override
    public List<Publisher> findByCode(String code) {
        return null;
    }
}
