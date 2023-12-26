package com.jio.librarymanagementsystem.controller;

import com.jio.librarymanagementsystem.model.LibraryTransaction;
import com.jio.librarymanagementsystem.service.LibraryTransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class LibraryTransactionController {
    private final LibraryTransactionService transactionService;

    public LibraryTransactionController(LibraryTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<LibraryTransaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public LibraryTransaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/borrow")
    public LibraryTransaction borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return transactionService.borrowBook(userId, bookId);
    }

    @PostMapping("/return/{transactionId}")
    public LibraryTransaction returnBook(@PathVariable Long transactionId) {
        return transactionService.returnBook(transactionId);
    }

    @PostMapping("/renew/{transactionId}")
    public LibraryTransaction renewBook(@PathVariable Long transactionId) {
        return transactionService.renewBook(transactionId);
    }
}
