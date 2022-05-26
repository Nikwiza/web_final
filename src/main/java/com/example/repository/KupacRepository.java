package com.example.repository;

import com.example.entity.Korisnik;
import com.example.entity.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Long> {
    public Kupac findByKorisnicko(String korisnicko);
}
