package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.DumplingsOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<DumplingsOrder, Long> {

    List<DumplingsOrder> findByDeliveryZip(String deliveryZip);

    List<DumplingsOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    @Query("select o from DumplingsOrder o where o.deliveryCity = 'Seattle'")
    List<DumplingsOrder> readOrdersDeliveredInSeattle();
}
