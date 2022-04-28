package com.example.repository;

import com.example.entity.Tipkupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipkupcaRepository extends JpaRepository<Tipkupca, Long> {
}
