package com.jio.librarymanagementsystem.service;

import com.jio.librarymanagementsystem.model.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private final BookService bookService = new BookServiceImpl();
    // type Book Service so we can use all the methods but a bookServiceImpl obj to call the overridden methods

    @Test
    void testCreateAndGetBook() {
        Book book = new Book(123L, "The Lightening Thief", "Rick Riordan");

        Book createdBook = bookService.createBook(book);
        assertNotNull(createdBook.getId());

        Book retrievedBook = bookService.getBookById(createdBook.getId());
        assertNotNull(retrievedBook); // not NUll then that means it has been created.
        assertEquals(createdBook.getId(), retrievedBook.getId());
        assertEquals("The Lightening Thief", retrievedBook.getTitle());
        assertEquals("Rick Riordan", retrievedBook.getAuthor());
    }


}
