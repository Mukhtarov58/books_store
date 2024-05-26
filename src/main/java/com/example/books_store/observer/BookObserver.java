package com.example.books_store.observer;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookObserver {
    @Autowired
    private BookObservable bookObservable;

    @Autowired
    private EmailNotificationListener emailListener;

    @Autowired
    private LogListener logListener;

    @PostConstruct
    public void init() {
        // Подписываемся на события
        bookObservable.addObserver(emailListener);
        bookObservable.addObserver(logListener);
    }
}