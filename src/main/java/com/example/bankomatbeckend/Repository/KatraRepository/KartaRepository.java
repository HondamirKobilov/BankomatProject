package com.example.bankomatbeckend.Repository.KatraRepository;

import com.example.bankomatbeckend.Entity.KartaEntity.Karta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KartaRepository extends JpaRepository<Karta,Integer> {
    Optional<Karta> findByMaxsusRaqam(String maxsusRaqam);
    Optional<Karta> findByMaxsusRaqamAndPinKod(String maxsusRaqam, Integer pinKod);
}
