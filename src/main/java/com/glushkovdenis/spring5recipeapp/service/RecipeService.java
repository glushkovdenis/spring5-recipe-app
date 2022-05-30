package com.glushkovdenis.spring5recipeapp.service;

import com.glushkovdenis.spring5recipeapp.commands.RecipeCommand;
import com.glushkovdenis.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
