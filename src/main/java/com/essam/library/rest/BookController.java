package com.essam.library.rest;

import com.essam.library.model.Book;
import com.essam.library.model.request.*;
import com.essam.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/book-id/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        Book book = bookService.findById(bookId);
        if (book == null) {
            throw new NotFoundException("Book Not Found");
        }
        return book;
    }

    @DeleteMapping("/delete-book-by-id/{bookId}")
    public String deleteBookById(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        return "Book has been deleted";
    }

    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/add-book-to-library")
    public String addBookToLibrary(@RequestBody LibraryBookRequest libraryBookRequest) {
        return bookService.addBookToLibrary(libraryBookRequest);
    }

    @PutMapping("/vendor-sells-book")
    public String vendorSellsBook(@RequestBody VendorBookRequest vendorBookRequest) {
        return bookService.vendorSellsBook(vendorBookRequest);
    }

    @PutMapping("/publish-book")
    public String publishBook(@RequestBody PublisherBookRequest publisherBookRequest) {
        return bookService.publishBook(publisherBookRequest);
    }

    @PutMapping("/assign-author-to-book")
    public String assignAuthorToBook(@RequestBody AuthorBookRequest authorBookRequest) {
        return bookService.assignAuthorToBook(authorBookRequest);
    }

    @PutMapping("/employee-issue-receive-book")
    public ResponseEntity<?> employeeIssueOrReceiveBook(@RequestBody EmployeeBookRequest employeeBookRequest) { {
        bookService.employeeIssueOrReceiveBook(employeeBookRequest.getEmployeeId(), employeeBookRequest.getBookId());
        return ResponseEntity.ok().build();
    }

    }

}
