package backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(Model model, @PathVariable ("id") Long bookId ) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editBook(Model model, @PathVariable("id") Long bookId) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
    
}
