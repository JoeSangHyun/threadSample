package com.example.threadsample.data.repository;

import com.example.threadsample.data.entity.PortFolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortFolioRepository extends JpaRepository<PortFolio, Long> {
    List<PortFolio> findAll();

    Optional<PortFolio> findByIdx(Long idx);
}
