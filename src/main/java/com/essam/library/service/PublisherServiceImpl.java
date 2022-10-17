package com.essam.library.service;

import com.essam.library.model.Publisher;
import com.essam.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(int publisherId) {
        Optional<Publisher> result = publisherRepository.findById(publisherId);
        Publisher publisher = null;
        if (result.isPresent()) {
            publisher = result.get();
        }
        return publisher;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(int publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
