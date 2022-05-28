package com.glushkovdenis.spring5recipeapp.controller;

import com.glushkovdenis.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {

        Long l = Long.valueOf(id).longValue();

        model.addAttribute("recipe", recipeService.findById(l));

        return "recipe/show";
    }
}
