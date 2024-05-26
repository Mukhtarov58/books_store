package com.example.books_store.observer;

import com.example.books_store.model.Book;
import org.springframework.stereotype.Component;

@Component

public class LogListener implements Observer {
    @Override
    public void update(String eventType, Book book) {
        System.out.println("Log entry: " + eventType + " book: " + book.getName());
    }
}