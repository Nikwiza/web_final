package com.company.repository;

import com.company.entity.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * This is a class that describes the manager
 *
 * */

// Primer Repository interfejsa
// Ime interfejsa je <Ime klase>Repository pa to nasledjuje JpaRepository<Ime klase, Tip surugatnog kljuca>

public interface ArtikalRepository extends JpaRepository<Artikal, Long> {
}
