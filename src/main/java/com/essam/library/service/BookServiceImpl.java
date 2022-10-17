package com.essam.library.service;

import com.essam.library.model.*;
import com.essam.library.model.request.AuthorBookRequest;
import com.essam.library.model.request.LibraryBookRequest;
import com.essam.library.model.request.PublisherBookRequest;
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

    private final AuthorService authorService;

    private final PublisherService publisherService;

    private final EmployeeService employeeService;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, LibraryService libraryService, VendorService vendorService, AuthorService authorService, PublisherService publisherService, EmployeeService employeeService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
        this.vendorService = vendorService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.employeeService = employeeService;
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

    @Override
    public String publishBook(PublisherBookRequest publisherBookRequest) {
        Book book = this.findById(publisherBookRequest.getBookId());
        Publisher publisher = publisherService.findById(publisherBookRequest.getPublisherCode());
        book.setPublisher(publisher);
        bookRepository.save(book);
        return "Published";
    }

    @Override
    public String assignAuthorToBook(AuthorBookRequest authorBookRequest) {
        Book book = this.findById(authorBookRequest.getBookId());
        Author author = authorService.findById(authorBookRequest.getAuthorCode());
        book.setAuthor(author);
        bookRepository.save(book);
        return "Assigned";
    }

    @Override
    public void employeeIssueOrReceiveBook(int employeeId, int bookId) {
        Book book = findById(bookId);
        Employee employee = employeeService.getById(employeeId);
        book.setEmployee(employee);
        bookRepository.save(book);
    }
}
