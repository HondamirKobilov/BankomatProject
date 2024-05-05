package com.example.bankomatbeckend.Repository.KatraRepository;
import com.example.bankomatbeckend.Entity.KartaEntity.Muddat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuddatRepository extends JpaRepository<Muddat, Integer> {
    boolean existsByBankIdAndKartaTuriIdAndMuddati(Integer muddat, Integer bankId, Integer kartaTuriId);
}
