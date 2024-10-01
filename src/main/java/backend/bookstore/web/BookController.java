package backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.CategoryRepository;



@Controller
public class BookController {
    
    @Autowired
    private BookRepository repository;
    @Autowired 
    private CategoryRepository crepository;
    
    @RequestMapping(value = "/booklist")
    public String listBooks(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    // Restful service to get all books
    @RequestMapping("/books")
    public @ResponseBody List<Book> ListBooksRest() {
        return (List<Book>) repository.findAll();
    }

    //Restful service to get one book by id
    @RequestMapping(value="/book/{id}")
    public @ResponseBody Optional <Book> findBookByIdRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }  
    
    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return"addbook";
    }
    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(Model model, @PathVariable ("id") Long bookId ) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editBook(Model model, @PathVariable("id") Long bookId) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
    
    
}
