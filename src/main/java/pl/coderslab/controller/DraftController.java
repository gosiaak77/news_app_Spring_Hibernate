package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.ArticleRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    Validator validator;

    @GetMapping("")
    public String showAll(Model model){
        List<Article> articles = articleRepository.findAllDrafts();
        model.addAttribute("articles", articles);
        return "/draft/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("article", new Article());
        return "draft/form";
    }

    @PostMapping("/form")
    public String form(@Validated({Default.class}) Article article, BindingResult validResult) {
        if (validResult.hasErrors()) {
            return "draft/form";
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
        return "draft/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Validated({Default.class}) Article article, BindingResult validResult){
        if (validResult.hasErrors()) {
            return "article/form";
        }
        articleRepository.save(article);
        return "redirect:/article";
    }
}
