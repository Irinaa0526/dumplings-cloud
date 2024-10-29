package com.example.dumplingscloud.core.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("dumplings")
public class Dumplings {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)    // ключ раздела
    private UUID id = Uuids.timeBased();

    @NotNull
    @jakarta.validation.constraints.Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @jakarta.validation.constraints.Size(min=1, message="You must choose at least 1 ingredient")
    @Column("ingredients")
    private List<IngredientUDT> ingredients = new ArrayList<>();

    @jakarta.validation.constraints.NotNull(message="You must choose portion size")
    private Size size;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)  // ключкластеризации
    private Date createdAt = new Date();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(new IngredientUDT(ingredient.getName(), ingredient.getType()));
    }

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
