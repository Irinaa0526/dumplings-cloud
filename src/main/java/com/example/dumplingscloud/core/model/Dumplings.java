package com.example.dumplingscloud.core.model;

import lombok.Data;

import java.util.List;

@Data
public class Dumplings {

    private String name;
    private List<Ingredient> ingredients;
    private Size size;

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
