package com.example.dumplingscloud.core.config;

import com.example.dumplingscloud.core.model.Ingredient;
import com.example.dumplingscloud.core.repo.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository) {
        return args -> {
            ingredientRepository.save(new Ingredient("CLS", "Classic", Ingredient.Type.WRAP));
            ingredientRepository.save(new Ingredient("TMT", "Tomato", Ingredient.Type.WRAP));
            ingredientRepository.save(new Ingredient("GRC", "Garlic", Ingredient.Type.WRAP));
            ingredientRepository.save(new Ingredient("SPN", "Spinach", Ingredient.Type.WRAP));

            ingredientRepository.save(new Ingredient("BF", "Beef", Ingredient.Type.PROTEIN));
            ingredientRepository.save(new Ingredient("PRK", "Pork", Ingredient.Type.PROTEIN));
            ingredientRepository.save(new Ingredient("LMB", "Lamb", Ingredient.Type.PROTEIN));
            ingredientRepository.save(new Ingredient("CHKN", "Chicken", Ingredient.Type.PROTEIN));

            ingredientRepository.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
            ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));

            ingredientRepository.save(new Ingredient("TOM", "Tomato", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("MNS", "Mayonnaise", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("SCR", "Sour cream", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("GAR", "Garlic", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("TKE", "Tkemali", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("MATS", "Matsoni", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("SATS", "Satsebeli", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("ADJ", "Adjika", Ingredient.Type.SAUCE));
        };
    }
}
