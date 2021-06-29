package com.example.gleamer.repository;

import com.example.gleamer.model.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  MetaDataRepository  extends JpaRepository<MetaData, Long> {
    Optional<MetaData> findById(Long id);
}

