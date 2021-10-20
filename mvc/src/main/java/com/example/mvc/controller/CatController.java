package com.example.mvc.controller;

import com.example.mvc.model.database.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {

    @GetMapping(value = "/cats")
    public String showCats(Model model) {
        model.addAttribute("cats", new Database().getCats());
        return "cats";
    }
}
