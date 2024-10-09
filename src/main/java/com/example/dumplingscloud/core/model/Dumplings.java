package com.example.dumplingscloud.core.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Dumplings {

    private Long id;
    @NotNull
    @jakarta.validation.constraints.Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    @NotNull
    @jakarta.validation.constraints.Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
    @jakarta.validation.constraints.NotNull(message="You must choose portion size")
    private Size size;
    private Date createdAt = new Date();

    public enum Size {
        SMALL(10), MIDDLE(20), BIG(30), BIGMAX(50);
        private final Integer count;

        Size(Integer count) {
            this.count = count;
        }

        public Integer getCount() {
            return count;
        }
    }
}
