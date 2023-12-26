package com.jio.librarymanagementsystem.service;

import com.jio.librarymanagementsystem.model.LibraryTransaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTransactionServiceTest {
    private final LibraryTransactionService transactionService = new LibraryTransactionServiceImpl();

    @Test
    void testBorrowBook() {
        // Assume the existence of book and user
        Long userId = 1L;
        Long bookId = 1L;

        LibraryTransaction transaction = transactionService.borrowBook(userId, bookId);
        assertNotNull(transaction.getId());
        assertEquals(bookId, transaction.getBookId());
        assertEquals(userId, transaction.getUserId());
        assertNotNull(transaction.getCheckoutDate());
        assertNull(transaction.getReturnDate());
    }

    // Can add more tests for returnBook, renewBook, and other scenarios
}
