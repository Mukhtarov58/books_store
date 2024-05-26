package com.example.books_store.observer;

import com.example.books_store.model.Book;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component

public class BookObservable  {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String eventType, Book book) {
        for (Observer observer : observers) {
            observer.update(eventType, book);
        }
    }
}
