package com.example.bankomatbeckend.Repository.KatraRepository;

import com.example.bankomatbeckend.Entity.KartaEntity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {
      boolean existsByNomi(String nomi);
}
