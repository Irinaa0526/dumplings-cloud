package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.DumplingsOrder;

public interface OrderRepository {
    DumplingsOrder save(DumplingsOrder dumplingsOrder);
}
