package com.apptics.library;

import com.apptics.library.model.Author;
import com.apptics.library.model.Book;
import com.apptics.library.model.Category;
import com.apptics.library.repository.AuthorRepository;
import com.apptics.library.repository.BookRepository;
import com.apptics.library.repository.CategoryRepository;
import com.apptics.library.repository.PublisherRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	//Config OpenAPI 3.0
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Library API")
				.version("1.0")
				.description("API para gestion de libros"));
	}

	@Bean
	public CommandLineRunner run(
			CategoryRepository categoryRepository,
			AuthorRepository authorRepository,
			BookRepository bookRepository,
			PublisherRepository publisherRepository
	) {
		return (args) -> {
			Book book = new Book("Java 8", "Libro de Java 8", "123456");
			Author author = new Author(
					"Juan Perez",
					"juanperez@gmail.com",
					"Bio de Juan Perez",
					"www.juanperez.com",
					"Descripcion de Juan Perez"
			);
			Category category = new Category("Rust");
			book.getAuthors().add(author);
			book.getCategories().add(category);
			author.getBooks().add(book);
			bookRepository.save(book);

			Book book2 = new Book("Java 11", "Libro de Java 11", "123457");
			Author author2 = new Author(
					"Pedro Navarrrete",
					"pedron@gmail.com",
					"Bio de Pedro Navarrrete",
					"www.pedron.com",
					"Descripcion de Pedro Navarrrete"
			);
			Category category2 = new Category("Blokchain");
			book2.getAuthors().add(author2);
			book2.getCategories().add(category2);
			author2.getBooks().add(book2);
			bookRepository.save(book2);
		};
	}




}
