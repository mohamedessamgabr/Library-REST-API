package com.essam.library.service;

import com.essam.library.model.Library;
import com.essam.library.model.request.LibraryAdminRequest;

import java.util.List;

public interface LibraryService {

    List<Library> findAll();

    Library save(Library library);

    Library findByName(String name);

    void deleteByName(String name);

    String assignAdminToLibrary(LibraryAdminRequest libraryAdminRequest);
}
