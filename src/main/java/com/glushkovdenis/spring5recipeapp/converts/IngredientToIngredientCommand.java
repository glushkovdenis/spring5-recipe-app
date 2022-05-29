package com.glushkovdenis.spring5recipeapp.converts;

import com.glushkovdenis.spring5recipeapp.commands.IngredientCommand;
import com.glushkovdenis.spring5recipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomCommand) {
        this.uomCommand = uomCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setUnitOfMeasure(uomCommand.convert(source.getUom()));
        return ingredientCommand;
    }
}
