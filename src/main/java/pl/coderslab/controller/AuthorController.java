package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.validation.Valid;
import javax.validation.Validator;


@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorDao authorDao;

    @Autowired
    Validator validator;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("author", new Author());
        return "/author/form";
    }

    @PostMapping("/form")
    public String add(@Valid Author author, BindingResult validResult){
        if (validResult.hasErrors()) {
            return "author/form";
        }
        authorDao.save(author);
        return "redirect:/author";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("author", authorDao.findById(id));
        return "author/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Author author, BindingResult validResult){
        if (validResult.hasErrors()) {
            return "author/form";
        }
        authorDao.save(author);
        return "redirect:/author";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("author", authorDao.findById(id));
        return "author/delete";
    }

    @GetMapping("/deleteConfirmed/{id}")
    public String delete(@PathVariable Long id){
        authorDao.delete(id);
        return "redirect:/author";
    }

}
