package com.glushkovdenis.spring5recipeapp.bootstrap;

import com.glushkovdenis.spring5recipeapp.domain.*;
import com.glushkovdenis.spring5recipeapp.repositories.CategoryRepository;
import com.glushkovdenis.spring5recipeapp.repositories.RecipeRepository;
import com.glushkovdenis.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    CategoryRepository categoryRepository;
    RecipeRepository recipeRepository;
    UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading Bootstrap Data");
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaspoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tablespoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if(!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if(!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found!");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();

        Optional<Category> americanCategory = categoryRepository.findByDescription("American");
        if(!americanCategory.isPresent()) {
            throw new RuntimeException("Expected Category not found!");
        }

        Optional<Category> mexicanCategory = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategory.isPresent()) {
            throw new RuntimeException("Expected Category not found!");
        }

        Category american = americanCategory.get();
        Category mexican = mexicanCategory.get();

        //Guacamole
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections(
                "1. Cut the avocado:\n"
                + "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl."
                + "2. Mash the avocado flesh:"
                + "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)"
                + "3. Add the remaining ingredients to taste"
                + "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
                + "\n"
                + "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n"
                + "\n"
                + "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste."
                + "4. Serve immediately"
                + "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n"
                + "\n"
                + "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips."
        );
        Note guacNote = new Note();
        guacNote.setRecipeNotes(
                "Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards."
                + "Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving."
        );
        guacamole.setNotes(guacNote);
        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacamole.addIngredient(new Ingredient("kosher salt", new BigDecimal(".25"), eachUom));
        guacamole.addIngredient(new Ingredient("fresh lime or lemon juice", new BigDecimal(1), tablespoonUom));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom));
        guacamole.addIngredient(new Ingredient("serrano (or jalapeño) chilis, stems and seeds removed, minced", new BigDecimal(1), eachUom));
        guacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoonUom));
        guacamole.addIngredient(new Ingredient("freshly ground black pepper", new BigDecimal(1), pinchUom));
        guacamole.addIngredient(new Ingredient("ripe tomato, chopped (optional)", new BigDecimal(".5"), eachUom));
        guacamole.addIngredient(new Ingredient("Red radish or jicama slices for garnish (optional)", new BigDecimal(1), eachUom));

        guacamole.getCategories().add(american);
        guacamole.getCategories().add(mexican);

        recipes.add(guacamole);

        //TODO: Spicy Grilled Chicken Tacos
        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setPrepTime(20);
        tacos.setCookTime(15);
        tacos.setDifficulty(Difficulty.EASY);
        tacos.setDirections(
                "1. Prepare a gas or charcoal grill for medium-high, direct heat"
              + "2. Make the marinade and coat the chicken:\n"
              + "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n"
              + "\n"
              + "Set aside to marinate while the grill heats and you prepare the rest of the toppings."
              + "3. Grill the chicken:\n"
              + "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes."
              + "4. Warm the tortillas:\n"
              + "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n"
              + "\n"
              + "Wrap warmed tortillas in a tea towel to keep them warm until serving."
              + "5. Assemble the tacos:\n"
              + "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges."
        );
        Note tacosNote = new Note();
        tacosNote.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        tacos.setNotes(tacosNote);
        tacos.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tablespoonUom));
        tacos.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), teaspoonUom));
        tacos.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), teaspoonUom));
        tacos.addIngredient(new Ingredient("sugar", new BigDecimal(1), teaspoonUom));
        tacos.addIngredient(new Ingredient("salt", new BigDecimal(".5"), teaspoonUom));
        tacos.addIngredient(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), eachUom));
        tacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespoonUom));
        tacos.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUom));
        tacos.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tablespoonUom));
        tacos.addIngredient(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(4), eachUom));

        tacos.getCategories().add(american);
        tacos.getCategories().add(mexican);

        recipes.add(tacos);

        return recipes;
    }
}
