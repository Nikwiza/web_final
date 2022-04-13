package com.company.repository;

import com.company.entity.Komentar;
import com.company.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

}
