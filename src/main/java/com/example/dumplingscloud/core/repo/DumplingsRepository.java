package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.Dumplings;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DumplingsRepository extends CrudRepository<Dumplings, UUID> {
}
