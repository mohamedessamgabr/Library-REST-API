package com.essam.library.service;

import com.essam.library.model.Book;
import com.essam.library.model.Library;
import com.essam.library.model.Vendor;
import com.essam.library.model.request.LibraryBookRequest;
import com.essam.library.model.request.VendorBookRequest;
import com.essam.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    private final LibraryService libraryService;

    private final VendorService vendorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, LibraryService libraryService, VendorService vendorService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
        this.vendorService = vendorService;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int bookId) {
        Optional<Book> result = bookRepository.findById(bookId);
        Book book = null;
        if(result.isPresent()) {
            book = result.get();
        }
        return book;
    }

    @Override
    public void deleteById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public String addBookToLibrary(LibraryBookRequest libraryBookRequest) {
        Book book = this.findById(libraryBookRequest.getBookId());
        Library library = libraryService.findByName(libraryBookRequest.getLibraryName());
        book.setLibrary(library);
        bookRepository.save(book);
        return "Saved";
    }

    @Override
    public String vendorSellsBook(VendorBookRequest vendorBookRequest) {
        Book book = this.findById(vendorBookRequest.getBookId());
        Vendor vendor = vendorService.findById(vendorBookRequest.getVendorCode());
        book.setVendor(vendor);
        bookRepository.save(book);
        return "Saved";
    }
}
