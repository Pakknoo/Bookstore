package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
		Category category1 = new Category("IT");
		Category category2 = new Category("Kauhu");
		Category category3 = new Category("Komedia");
		crepository.save(category1);
		crepository.save(category2);
		crepository.save(category3);

		Book book1 = new Book("Nimi1", "Kirjailija1", 2000, "11111-11", 20.90, category1);
		Book book2 = new Book("Nimi2", "Kirjailija2", 2001, "11111-12", 30.90, category2);
		Book book3 = new Book("Nimi3", "Kirjailija3", 2002, "11111-13", 40.90, category3);
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		};
		}  

}
