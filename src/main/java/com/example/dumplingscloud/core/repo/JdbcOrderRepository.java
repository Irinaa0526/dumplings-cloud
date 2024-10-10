package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.Dumplings;
import com.example.dumplingscloud.core.model.DumplingsOrder;
import com.example.dumplingscloud.core.model.Ingredient;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public DumplingsOrder save(DumplingsOrder dumplingsOrder) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Dumplings_Order (delivery_name, delivery_street, delivery_city, " +
                        "delivery_state, delivery_zip, cc_number, cc_expiration, cc_cvv, placed_at) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        dumplingsOrder.setPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        dumplingsOrder.getDeliveryName(),
                        dumplingsOrder.getDeliveryStreet(),
                        dumplingsOrder.getDeliveryCity(),
                        dumplingsOrder.getDeliveryState(),
                        dumplingsOrder.getDeliveryZip(),
                        dumplingsOrder.getCcNumber(),
                        dumplingsOrder.getCcExpiration(),
                        dumplingsOrder.getCcCVV(),
                        dumplingsOrder.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        dumplingsOrder.setId(orderId);

        List<Dumplings> dumplingsList = dumplingsOrder.getDumplings();
        int i = 0;
        for (Dumplings dumplings : dumplingsList) {
            saveDumplings(orderId, i++, dumplings);
        }
        return dumplingsOrder;
    }

    private long saveDumplings(Long orderId, int orderKey, Dumplings dumplings) {
        dumplings.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Dumplings (name, size, created_at, dumplings_order, dumplings_order_key) " +
                        "values (?, ?, ?, ?, ?)",
                Types.VARCHAR, Types.INTEGER, Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        dumplings.getName(),
                        dumplings.getSize().getCount(),
                        dumplings.getCreatedAt(),
                        orderId,
                        orderKey));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long dumplingsId = keyHolder.getKey().longValue();
        dumplings.setId(dumplingsId);

        saveIngredientRefs(dumplingsId, dumplings.getIngredients());

        return dumplingsId;
    }

    private void saveIngredientRefs(long dumplingsId, List<Ingredient> ingredients) {
        int key = 0;

        for (Ingredient ingredient : ingredients) {
            jdbcOperations.update("insert into Ingredient_Ref (ingredient_id, dumplings_id, dumplings_key) " +
                    "values (?, ?, ?)",
                    ingredient.getId(), dumplingsId, key++);
        }
    }
}
