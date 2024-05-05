package com.example.bankomatbeckend.Repository;

import com.example.bankomatbeckend.Entity.KartaEntity.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManzilRepository extends JpaRepository<Manzil,Integer> {

    boolean existsByViloyatAndTumanAndKocha(String viloyat, String tuman, String kocha);

}
