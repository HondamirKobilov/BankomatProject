package com.example.bankomatbeckend.Repository.BankomatRepository;

import com.example.bankomatbeckend.Entity.BankomatEntity.Kommissiya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommissiyaRepositary extends JpaRepository<Kommissiya,Integer> {
    boolean existsByBankIdAndKartaTuriId(Integer bank_id, Integer kartaTuri_id);

}
