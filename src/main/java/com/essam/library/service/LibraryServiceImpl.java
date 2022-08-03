package com.essam.library.service;

import com.essam.library.model.Library;
import com.essam.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library findByName(String name) {
        Optional<Library> result = libraryRepository.findById(name);
        Library library = null;
        if (result.isPresent()) {
            library = result.get();
        }
        return library;
    }

    @Override
    public void deleteByName(String name) {
        libraryRepository.deleteById(name);
    }
}
