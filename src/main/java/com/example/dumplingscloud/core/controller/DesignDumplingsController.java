package com.example.dumplingscloud.core.controller;

import com.example.dumplingscloud.core.model.Dumplings;
import com.example.dumplingscloud.core.model.DumplingsOrder;
import com.example.dumplingscloud.core.model.Ingredient;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("dumplingsOrder")
public class DesignDumplingsController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CLS", "Classic", Ingredient.Type.WRAP),
                new Ingredient("TMT", "Tomato", Ingredient.Type.WRAP),
                new Ingredient("GRC", "Garlic", Ingredient.Type.WRAP),
                new Ingredient("SPN", "Spinach", Ingredient.Type.WRAP),

                new Ingredient("BF", "Beef", Ingredient.Type.PROTEIN),
                new Ingredient("PRK", "Pork", Ingredient.Type.PROTEIN),
                new Ingredient("LMB", "Lamb", Ingredient.Type.PROTEIN),
                new Ingredient("CHKN", "Chicken", Ingredient.Type.PROTEIN),

                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),

                new Ingredient("TOM", "Tomato", Ingredient.Type.SAUCE),
                new Ingredient("MNS", "Mayonnaise", Ingredient.Type.SAUCE),
                new Ingredient("SCR", "Sour cream", Ingredient.Type.SAUCE),
                new Ingredient("GAR", "Garlic", Ingredient.Type.SAUCE),
                new Ingredient("TKE", "Tkemali", Ingredient.Type.SAUCE),
                new Ingredient("MATS", "Matsoni", Ingredient.Type.SAUCE),
                new Ingredient("SATS", "Satsebeli", Ingredient.Type.SAUCE),
                new Ingredient("ADJ", "Adjika", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
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
