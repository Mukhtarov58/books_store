package com.example.books_store.bookService;

import com.example.books_store.bookRepository.BookRepository;
import com.example.books_store.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.books_store.TrackUserAction;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    @TrackUserAction
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @TrackUserAction
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    @TrackUserAction
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @TrackUserAction
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
