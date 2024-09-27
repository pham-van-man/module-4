package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.Book;
import org.example.bai_tap_1.model.LibraryCard;
import org.example.bai_tap_1.service.BookService;
import org.example.bai_tap_1.service.LibraryCardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final LibraryCardService libraryCardService;
    private LibraryCard libraryCard;

    public BookController(final BookService bookService, final LibraryCardService libraryCardService) {
        this.bookService = bookService;
        this.libraryCardService = libraryCardService;
    }

    @ModelAttribute("books")
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    @ModelAttribute("libraryCard")
    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    @GetMapping("")
    public String book() {
        return "book";
    }

    @GetMapping("borrow/{id}")
    public String borrowBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Book book = bookService.getBookById(id);
        bookService.reduceQuantity(book);
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setBook(book);
        libraryCard = libraryCardService.saveLibraryCard(libraryCard);
        this.libraryCard = libraryCard;
        redirectAttributes.addFlashAttribute("message", "Borrowed book successfully!");
        return "redirect:/libraryCard";
    }

    @GetMapping("libraryCard")
    public String libraryCard() {
        if (libraryCard == null) {
            return "redirect:";
        }
        return "libraryCard";
    }

    @GetMapping("return")
    public String returnBook(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        LibraryCard libraryCard = libraryCardService.getLibraryCardById(id);
        Book book = libraryCard.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookService.increaseQuantity(book);
        libraryCardService.deleteLibraryCard(libraryCard);
        redirectAttributes.addFlashAttribute("message", "Returned book successfully!");
        return "redirect:";
    }

    @GetMapping("returnBook")
    public String returnBook() {
        return "returnBook";
    }
}
