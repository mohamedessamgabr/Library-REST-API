package com.essam.library.model.request;

public class LibraryBookRequest {
    private int bookId;
    private String libraryName;

    public LibraryBookRequest() {
    }

    public LibraryBookRequest(int bookId, String libraryName) {
        this.bookId = bookId;
        this.libraryName = libraryName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
}
