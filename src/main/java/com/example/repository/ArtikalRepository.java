package com.example.repository;

import com.example.entity.Artikal;
import com.example.entity.Komentar;
import com.example.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *
 * This is a class that describes the manager
 *
 * */

// Primer Repository interfejsa
// Ime interfejsa je <Ime klase>Repository pa to nasledjuje JpaRepository<Ime klase, Tip surugatnog kljuca>

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Long> {
}
