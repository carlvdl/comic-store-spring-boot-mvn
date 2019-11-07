package com.example.comicstorespringbootmvn.publisher;

import com.example.comicstorespringbootmvn.user.User;

import java.util.List;

public interface IPublisherService {

    List<Publisher> findAll();

    List<Publisher> findByCode(String code);
}

