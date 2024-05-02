package com.apptics.library.service;

import com.apptics.library.model.Book;
import com.apptics.library.model.Category;
import com.apptics.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> searchBookByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> getBooksByCategory(Category category) {
        return bookRepository.findBooksByCategory(category);
    }
}
