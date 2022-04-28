package com.example.repository;

import com.example.entity.Stavka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Long> {

}
