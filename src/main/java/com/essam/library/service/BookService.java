package com.essam.library.service;

import com.essam.library.model.Book;
import com.essam.library.model.request.AuthorBookRequest;
import com.essam.library.model.request.LibraryBookRequest;
import com.essam.library.model.request.PublisherBookRequest;
import com.essam.library.model.request.VendorBookRequest;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Book findById(int bookId);

    void deleteById(int bookId);

    String addBookToLibrary(LibraryBookRequest libraryBookRequest);

    String vendorSellsBook(VendorBookRequest vendorBookRequest);


    String publishBook(PublisherBookRequest publisherBookRequest);

    String assignAuthorToBook(AuthorBookRequest authorBookRequest);

    void employeeIssueOrReceiveBook(int employeeId, int bookId);
}
