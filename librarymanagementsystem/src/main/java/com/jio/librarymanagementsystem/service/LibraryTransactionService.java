package com.jio.librarymanagementsystem.service;

import com.jio.librarymanagementsystem.model.LibraryTransaction;
import java.util.List;

public interface LibraryTransactionService {
    List<LibraryTransaction> getAllTransactions();
    LibraryTransaction getTransactionById(Long id);
    LibraryTransaction borrowBook(Long userId, Long bookId);
    LibraryTransaction returnBook(Long transactionId);
    LibraryTransaction renewBook(Long transactionId);
}
