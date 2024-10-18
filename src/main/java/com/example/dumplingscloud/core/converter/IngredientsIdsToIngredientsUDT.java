package com.example.dumplingscloud.core.converter;

import com.example.dumplingscloud.core.model.Ingredient;
import com.example.dumplingscloud.core.model.IngredientUDT;
import com.example.dumplingscloud.core.repo.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class IngredientsIdsToIngredientsUDT implements Converter<String[], List<IngredientUDT>> {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<IngredientUDT> convert(String[] ingredients) {
        List<IngredientUDT> ingredientsUDT = new ArrayList<>();
        List<Ingredient> ingredientsList = (List<Ingredient>) ingredientRepository.findAllById(List.of(ingredients));
        for(Ingredient ingredient : ingredientsList) {
            ingredientsUDT.add(new IngredientUDT(ingredient.getName(), ingredient.getType()));
        }
        return ingredientsUDT;
    }
}
