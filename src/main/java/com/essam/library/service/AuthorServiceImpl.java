package com.essam.library.service;

import com.essam.library.model.Author;
import com.essam.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int authorId) {
        Author author = null;
        Optional<Author> result = authorRepository.findById(authorId);
        if(result.isPresent()) {
            author = result.get();
        }
        return author;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int authorId) {
        authorRepository.deleteById(authorId);
    }
}
