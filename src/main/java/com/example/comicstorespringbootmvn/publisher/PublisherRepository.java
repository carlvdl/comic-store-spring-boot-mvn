package com.example.comicstorespringbootmvn.publisher;



import com.example.comicstorespringbootmvn.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    List<Publisher> findByCode(String code);

    List<Publisher> findAll();

}