package com.glushkovdenis.spring5recipeapp.service;

import com.glushkovdenis.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
