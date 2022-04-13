package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {
}
