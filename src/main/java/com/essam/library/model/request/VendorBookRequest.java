package com.essam.library.model.request;

public class VendorBookRequest {
    private int bookId;
    private int vendorCode;

    public VendorBookRequest() {
    }

    public VendorBookRequest(int bookId, int vendorCode) {
        this.bookId = bookId;
        this.vendorCode = vendorCode;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }
}
