package com.jio.librarymanagementsystem.service;

import com.jio.librarymanagementsystem.model.LibraryTransaction;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryTransactionServiceImpl implements LibraryTransactionService {
    private List<LibraryTransaction> transactions = new ArrayList<>();
    private long nextTransactionId = 1;

    @Override
    public List<LibraryTransaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public LibraryTransaction getTransactionById(Long id) {
        Optional<LibraryTransaction> foundTransaction = transactions.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
        return foundTransaction.orElse(null);
    }

    @Override
    public LibraryTransaction borrowBook(Long userId, Long bookId) {
        // Implement logic to check if the book is available and user is valid for borrowing
        // For simplicity, we'll assume the book is always available and the user is valid

        LibraryTransaction transaction = new LibraryTransaction(nextTransactionId++, bookId, userId, LocalDate.now(), null);
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public LibraryTransaction returnBook(Long transactionId) {
        Optional<LibraryTransaction> foundTransaction = transactions.stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findFirst();

        if (foundTransaction.isPresent()) {
            LibraryTransaction transaction = foundTransaction.get();
            transaction.setReturnDate(LocalDate.now());
            return transaction;
        }

        return null;
    }

    @Override
    public LibraryTransaction renewBook(Long transactionId) {
        Optional<LibraryTransaction> foundTransaction = transactions.stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findFirst();

        if (foundTransaction.isPresent()) {
            LibraryTransaction transaction = foundTransaction.get();
            // Implement logic to check if the book is renewable
            // For simplicity, we'll assume the book is always renewable

            transaction.setCheckoutDate(LocalDate.now());
            transaction.setReturnDate(null);
            return transaction;
        }

        return null;
    }
}
