package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.DumplingsOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<DumplingsOrder, UUID> {
}
