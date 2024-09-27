package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Book;
import org.example.bai_tap_1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void reduceQuantity(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity() < 0) {
            throw new UnsupportedOperationException();
        }
        bookRepository.save(book);
    }

    @Override
    public void increaseQuantity(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
