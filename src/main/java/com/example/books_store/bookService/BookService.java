package com.example.books_store.bookService;

import com.example.books_store.bookRepository.BookRepository;
import com.example.books_store.model.Book;
import com.example.books_store.observer.BookObservable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.books_store.TrackUserAction;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookObservable bookObservable;

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
        // Сохраняем книгу
        Book savedBook = bookRepository.save(book);
        // Уведомляем наблюдателей об изменении (событии "сохранение книги")
        bookObservable.notifyObservers("SAVE", savedBook);
        return savedBook;
    }

    @TrackUserAction
    public void deleteById(Long id) {
        // Удаление книги
        bookRepository.deleteById(id);
        // Уведомляем наблюдателей об изменении (событии "удаление книги")
        bookObservable.notifyObservers("DELETE", new Book()); // Мы не передаём объект, потому что он уже удалён
    }
}
