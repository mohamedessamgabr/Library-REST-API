package com.essam.library.rest;

import com.essam.library.model.Publisher;
import com.essam.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @PostMapping("/add-publisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }
}
