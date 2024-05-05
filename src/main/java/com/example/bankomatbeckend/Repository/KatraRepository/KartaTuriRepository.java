package com.example.bankomatbeckend.Repository.KatraRepository;

import com.example.bankomatbeckend.Entity.KartaEntity.KartaTuri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KartaTuriRepository  extends JpaRepository<KartaTuri,Integer> {
     boolean existsByNomi(String nomi);

}
