package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    Validator validator;

    @GetMapping("/{id}")
    public String showAllByCategoryId(@PathVariable Long id, Model model){
        List<Article> articles = categoryRepository.findCategoryById(id).getArticles();
        model.addAttribute("articles", articles);
        model.addAttribute("category", categoryRepository.findCategoryById(id));
        return "/category/categoryArticles";
    }

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/list";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("category", new Category());
        return "/category/form";
    }

    @PostMapping("/form")
    public String add(@Valid Category category, BindingResult validResult){
        if (validResult.hasErrors()) {
            return "category/form";
        }
        categoryRepository.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryRepository.findCategoryById(id));
        return "category/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Category category, BindingResult validResult){
        if (validResult.hasErrors()) {
            return "category/form";
        }
        categoryRepository.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryRepository.findCategoryById(id));
        return "category/delete";
    }

    @GetMapping("/deleteConfirmed/{id}")
    public String delete(@PathVariable Long id){
        categoryRepository.delete(id);
        return "redirect:/category";
    }

}
