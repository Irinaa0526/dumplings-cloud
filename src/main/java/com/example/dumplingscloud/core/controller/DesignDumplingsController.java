package com.example.dumplingscloud.core.controller;

import com.example.dumplingscloud.core.model.Dumplings;
import com.example.dumplingscloud.core.model.DumplingsOrder;
import com.example.dumplingscloud.core.model.Ingredient;
import com.example.dumplingscloud.core.repo.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("dumplingsOrder")
public class DesignDumplingsController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignDumplingsController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType((List<Ingredient>) ingredients, type));
        }
        model.addAttribute("size", Dumplings.Size.values());
    }

    @ModelAttribute(name = "dumplingsOrder")
    public DumplingsOrder order() {
        return new DumplingsOrder();
    }

    @ModelAttribute(name = "dumplings")
    public Dumplings dumplings() {
        return new Dumplings();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(ing -> ing.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDumplings(@Valid Dumplings dumplings, Errors errors,
                                   @ModelAttribute DumplingsOrder dumplingsOrder) {
        if (errors.hasErrors()) {
            return "design";
        }

        dumplingsOrder.addDumplings(dumplings);
        log.info("Processing dumplings: {}", dumplings);

        return "redirect:/orders/current";
    }
}
