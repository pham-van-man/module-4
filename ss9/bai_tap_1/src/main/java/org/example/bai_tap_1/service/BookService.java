package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void reduceQuantity(Book book);

    void increaseQuantity(Book book);

    Book getBookById(Long id);
}
