package com.essam.library.model.request;

public class PublisherBookRequest {
    private int bookId;
    private int publisherCode;

    public PublisherBookRequest() {
    }

    public PublisherBookRequest(int bookId, int publisherCode) {
        this.bookId = bookId;
        this.publisherCode = publisherCode;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(int publisherCode) {
        this.publisherCode = publisherCode;
    }
}
