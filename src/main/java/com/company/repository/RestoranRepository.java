package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestoranRepository extends JpaRepository<Restoran, Long> {
}
