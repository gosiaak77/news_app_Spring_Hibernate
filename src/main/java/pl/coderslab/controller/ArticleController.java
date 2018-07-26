package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.groupValidator.ValidationArticle;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    Validator validator;

    @ModelAttribute
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @GetMapping("")
    public String showAll(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "/article/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("article", new Article());
        return "article/form";
    }

    @PostMapping("/form")
    public String form(@Validated({ValidationArticle.class}) Article article, BindingResult validResult) {
        if (validResult.hasErrors()) {
            return "article/form";
        }
        articleRepository.save(article);
        return "redirect:/article";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("article", articleRepository.findArticleById(id));
        return "article/delete";
    }


    @GetMapping("/deleteConfirmed/{id}")
    public String delete(@PathVariable Long id){
        articleRepository.delete(articleRepository.findArticleById(id));
        return "redirect:/article";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("article", articleRepository.findArticleById(id));
        return "article/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Validated({ValidationArticle.class}) Article article, BindingResult validResult){
        if (validResult.hasErrors()) {
            return "article/form";
        }
        articleRepository.save(article);
        return "redirect:/article";
    }

}
