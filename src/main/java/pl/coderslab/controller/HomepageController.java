package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import java.util.List;

@Controller
public class HomepageController {
    @Autowired
    AuthorDao authorDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ArticleDao articleDao;

    @GetMapping("/")
    public String displayArticles(Model model){
        List<Article> articles = articleDao.findLast(5L);
        model.addAttribute("articles", articles);
        return "home";
    }


    @ModelAttribute
    public List<Category> categories(){
        return categoryDao.findAll();
    }

}
