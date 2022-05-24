package com.example.repository;

import com.example.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer, Long> {
    public Menadzer getById(Long id);
    public Menadzer findByIme(String ime);
    public Menadzer findByKorisnicko(String korisnicko);
}
