package backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
	private CategoryRepository crepository;

     @RequestMapping(value="/categorylist", method=RequestMethod.GET)
    public String showCategories(Model model){
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }
    @RequestMapping(value="/addcategory", method=RequestMethod.GET)
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category){
        crepository.save(category);
        return "redirect:categorylist";
    }
    
}
