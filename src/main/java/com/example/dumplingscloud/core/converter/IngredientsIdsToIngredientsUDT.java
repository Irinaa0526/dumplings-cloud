package com.example.dumplingscloud.core.converter;

import com.example.dumplingscloud.core.model.Ingredient;
import com.example.dumplingscloud.core.repo.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class IngredientsIdsToIngredientsUDT implements Converter<String[], List<Ingredient>> {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> convert(String[] ingredients) {
        List<Ingredient> ingredientsList = (List<Ingredient>) ingredientRepository.findAllById(List.of(ingredients));
        return ingredientsList;
    }
}
