package com.company.repository;

import com.company.entity.Artikal;
import com.company.entity.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {
}
