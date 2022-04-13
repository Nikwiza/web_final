package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Dostavljac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DostavljacRepository extends JpaRepository<Dostavljac, Long> {
}
