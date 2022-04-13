package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
}
