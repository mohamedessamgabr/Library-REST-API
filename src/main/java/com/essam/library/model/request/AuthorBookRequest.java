package com.essam.library.model.request;

public class AuthorBookRequest {

    private int bookId;
    private int authorCode;

    public AuthorBookRequest() {
    }

    public AuthorBookRequest(int bookId, int authorCode) {
        this.bookId = bookId;
        this.authorCode = authorCode;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(int authorCode) {
        this.authorCode = authorCode;
    }
}
