package com.jio.librarymanagementsystem.model;

import java.time.LocalDate;

public class LibraryTransaction {
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

    public LibraryTransaction() {
        // Default constructor for Jackson deserialization
    }

    public LibraryTransaction(Long id, Long bookId, Long userId, LocalDate checkoutDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}


