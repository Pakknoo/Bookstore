package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;
import backend.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository){
		return (args)->{
			Category category1 = new Category("kaunokirjallisuus");
			Category category2 = new Category("tietokirjallisuus");
			categoryRepository.save(category1);
			categoryRepository.save(category2);

			Book book1 = new Book("36 Uurnaa", "Sirpa Kähkönen", 2023, "9789523881860", 35.90, category1);
			Book book2 = new Book("Hävitys", "Iida Rauma", 2022, "2212343", 26.90, category1);
			Book book3 = new Book("Hands-on Full Stack Development with Spring Boot and React", "Juha Hinkula", 2022, "9781801816786", 42.30, category2);
			repository.save(book1);
			repository.save(book2);	
			repository.save(book3);	
		};
	}
	

}
