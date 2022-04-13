package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenadzerRepository extends JpaRepository<Menadzer, Long> {
}
