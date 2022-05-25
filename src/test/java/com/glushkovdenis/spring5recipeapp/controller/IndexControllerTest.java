package com.glushkovdenis.spring5recipeapp.controller;

import com.glushkovdenis.spring5recipeapp.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Mock
    IndexController indexController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        assertEquals(indexController.getIndexPage(model), "index");
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), Mockito.anySet());
    }
}