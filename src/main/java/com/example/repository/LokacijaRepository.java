package com.example.repository;

import com.example.entity.Lokacija;
import com.example.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
    public Lokacija findByAdresa(String adresa);
}
