package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
