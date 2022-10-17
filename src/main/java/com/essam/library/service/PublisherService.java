package com.essam.library.service;

import com.essam.library.model.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> findAll();

    Publisher findById(int publisherId);

    Publisher save(Publisher publisher);

    void deleteById(int publisherId);
}
