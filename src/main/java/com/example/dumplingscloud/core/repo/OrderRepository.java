package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.DumplingsOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<DumplingsOrder, Long> {
}
