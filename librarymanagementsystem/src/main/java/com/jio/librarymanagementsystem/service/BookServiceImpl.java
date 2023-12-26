package com.jio.librarymanagementsystem.service;

import org.springframework.stereotype.Service;
import com.jio.librarymanagementsystem.model.Book;
import org.springframework.context.annotation.Primary;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>();
    private long nextBookId = 1;

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> foundBook = books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
        return foundBook.orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        book.setId(nextBookId++);
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId().equals(id)) {
                updatedBook.setId(id);
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
