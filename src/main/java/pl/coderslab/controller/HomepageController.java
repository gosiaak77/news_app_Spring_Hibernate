package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Controller
public class HomepageController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/")
    public String displayArticles(Model model){
        List<Article> articles = articleRepository.findLastFiveArticles();
        model.addAttribute("articles", articles);
        return "home";
    }


    @ModelAttribute
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

}
