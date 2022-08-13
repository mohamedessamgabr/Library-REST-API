package com.essam.library.rest;

import com.essam.library.model.Library;
import com.essam.library.model.request.LibraryAdminRequest;
import com.essam.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryRestController {

    private LibraryService libraryService;

    @Autowired
    public LibraryRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/libraries")
    public List<Library> getLibraries() {
        return libraryService.findAll();
    }

    @GetMapping("/libraries/{name}")
    public Library getByName(@PathVariable String name) {
        Library library = libraryService.findByName(name);
        if(library == null) {
            throw  new NotFoundException("Library name: " + name + " not found");
        }
        return library;
    }

    @PostMapping("/libraries")
    public Library addLibrary(@RequestBody Library library) {
        return  libraryService.save(library);
    }

    @DeleteMapping("/libraries/{name}")
    public String deleteLibrary(@PathVariable String name) {
        Library library = libraryService.findByName(name);
        if(library == null) {
            throw  new NotFoundException("Library name: " + name + " not found");
        }
        libraryService.deleteByName(name);
        return "Library with name: " + name + " has been deleted";
    }

    @PostMapping("/assign-admin")
    public String AssignAdminToLibrary(@RequestBody LibraryAdminRequest libraryAdminRequest) {
        return libraryService.assignAdminToLibrary(libraryAdminRequest);
    }
}
