package com.essam.library.service;

import com.essam.library.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(int authorId);

    Author save(Author author);

    void deleteById(int authorId);
}
