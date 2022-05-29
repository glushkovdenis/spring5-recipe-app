package com.glushkovdenis.spring5recipeapp.converts;

import com.glushkovdenis.spring5recipeapp.commands.RecipeCommand;
import com.glushkovdenis.spring5recipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final NoteCommandToNote noteCommandToNote;
    private final CategoryCommandToCategory categoryConveter;
    private final IngredientCommandToIngredient ingredientConverter;

    public RecipeCommandToRecipe(NoteCommandToNote noteCommandToNote, CategoryCommandToCategory categoryConveter, IngredientCommandToIngredient ingredientConverter) {
        this.noteCommandToNote = noteCommandToNote;
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setDescription(source.getDescription());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setNotes(noteCommandToNote.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
