package com.apptics.library.repository;

import com.apptics.library.model.Book;
import com.apptics.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContaining(String title);

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c = :category")
    List<Book> findBooksByCategory(@Param("category") Category category);
}
