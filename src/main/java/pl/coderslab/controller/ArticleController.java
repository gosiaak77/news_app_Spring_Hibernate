package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleDao aricleDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    CategoryDao categoryDao;

    @ModelAttribute
    public List<Category> categories(){
        return categoryDao.findAll();
    }

    @ModelAttribute
    public List<Author> authors() {
        return authorDao.findAll();
    }

    @GetMapping("")
    public String showAll(Model model){
        List<Article> articles = aricleDao.findAll();
        model.addAttribute("articles", articles);
        return "/article/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("article", new Article());
        return "article/form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute Article article) {
        aricleDao.save(article);
        return "redirect:/article";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("article", aricleDao.findById(id));
        return "article/delete";
    }


    @GetMapping("/deleteConfirmed/{id}")
    public String delete(@PathVariable Long id){
        aricleDao.delete(aricleDao.findById(id));
        return "redirect:/article";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("article", aricleDao.findById(id));
        return "article/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Article article){
        aricleDao.save(article );
        return "redirect:/article";
    }

}
