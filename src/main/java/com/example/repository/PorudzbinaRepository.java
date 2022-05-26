package com.example.repository;

import com.example.entity.Kupac;
import com.example.entity.Porudzbina;
import com.example.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, UUID> {
    public Set<Porudzbina> getByRestoran(Restoran restoran);
    public Set<Porudzbina> getByKupac(Kupac kupac);
}
