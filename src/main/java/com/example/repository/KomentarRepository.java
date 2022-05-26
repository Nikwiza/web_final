package com.example.repository;

import com.example.entity.Komentar;
import com.example.entity.Porudzbina;
import com.example.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {
    public Set<Komentar> getByRestoran(Restoran restoran);
}
