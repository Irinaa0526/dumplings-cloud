package com.example.dumplingscloud.core.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType("dumplings")
public class DumplingsUDT {

    private final String name;
    private final List<IngredientUDT> ingredients;
}
