package com.example.repository;

import com.example.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {

    public Restoran findByNaziv(String naziv);
    public List<Restoran> findByTip(String tip);
}
