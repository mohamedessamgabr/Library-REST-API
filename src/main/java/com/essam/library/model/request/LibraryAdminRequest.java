package com.essam.library.model.request;

public class LibraryAdminRequest {

    private int adminId;
    private String libraryName;

    public LibraryAdminRequest() {
    }

    public LibraryAdminRequest(int adminId, String libraryName) {
        this.adminId = adminId;
        this.libraryName = libraryName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
