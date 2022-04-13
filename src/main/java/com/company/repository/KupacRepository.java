package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacRepository extends JpaRepository<Kupac, Long> {
}
