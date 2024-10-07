package com.example.dumplingscloud.core.converter;

import com.example.dumplingscloud.core.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("CLS", new Ingredient("CLS", "Classic", Ingredient.Type.WRAP));
        ingredientMap.put("TMT", new Ingredient("TMT", "Tomato", Ingredient.Type.WRAP));
        ingredientMap.put("GRC", new Ingredient("GRC", "Garlic", Ingredient.Type.WRAP));
        ingredientMap.put("SPN", new Ingredient("SPN", "Spinach", Ingredient.Type.WRAP));

        ingredientMap.put("BF", new Ingredient("BF", "Beef", Ingredient.Type.PROTEIN));
        ingredientMap.put("PRK", new Ingredient("PRK", "Pork", Ingredient.Type.PROTEIN));
        ingredientMap.put("LMB", new Ingredient("LMB", "Lamb", Ingredient.Type.PROTEIN));
        ingredientMap.put("CHKN", new Ingredient("CHKN", "Chicken", Ingredient.Type.PROTEIN));

        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));

        ingredientMap.put("TOM", new Ingredient("TOM", "Tomato", Ingredient.Type.SAUCE));
        ingredientMap.put("MNS", new Ingredient("MNS", "Mayonnaise", Ingredient.Type.SAUCE));
        ingredientMap.put("SCR", new Ingredient("SCR", "Sour cream", Ingredient.Type.SAUCE));
        ingredientMap.put("GAR", new Ingredient("GAR", "Garlic", Ingredient.Type.SAUCE));
        ingredientMap.put("TKE", new Ingredient("TKE", "Tkemali", Ingredient.Type.SAUCE));
        ingredientMap.put("MATS", new Ingredient("MATS", "Matsoni", Ingredient.Type.SAUCE));
        ingredientMap.put("SATS", new Ingredient("SATS", "Satsebeli", Ingredient.Type.SAUCE));
        ingredientMap.put("ADJ", new Ingredient("ADJ", "Adjika", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
