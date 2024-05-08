package com.example.books_store.bookController;

import com.example.books_store.bookService.BookService;
import com.example.books_store.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findByid(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }
    @PutMapping("/{id}")
    public Book update(@RequestBody Book book,@PathVariable Long id){
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
