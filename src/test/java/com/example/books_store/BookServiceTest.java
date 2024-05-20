package com.example.books_store;


import com.example.books_store.bookRepository.BookRepository;
import com.example.books_store.bookService.BookService;
import com.example.books_store.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindById() {
        Long id = 1L;
        Book book = new Book();
        book.setId(id);
        book.setName("Test Book");
        book.setAuthor("Test Author");

        when(bookRepository.findById(id)).thenReturn(Optional.of(book));


        Optional<Book> foundBook = bookService.findById(id);


        assertTrue(foundBook.isPresent());
        assertEquals("Test Book", foundBook.get().getName());
    }
}