package com.example.dumplingscloud.core.repo;

import com.example.dumplingscloud.core.model.Dumplings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DumplingsRepository extends CrudRepository<Dumplings, UUID> {
}
