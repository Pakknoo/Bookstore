package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.BookstoreRepository;
import backend.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookstoreRepository repository){
		return (args)->{
			Book b1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 25.90);
			Book b2 = new Book("Animal Farm", "George Orwell", 1945, "2212343", 26.90);
			repository.save(b1);
			repository.save(b2);
		};
	}

}
