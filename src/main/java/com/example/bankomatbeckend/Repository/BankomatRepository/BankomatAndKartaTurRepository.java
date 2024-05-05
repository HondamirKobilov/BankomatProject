package com.example.bankomatbeckend.Repository.BankomatRepository;

import com.example.bankomatbeckend.Entity.BankomatEntity.BankomatAndKartaTurId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankomatAndKartaTurRepository extends JpaRepository<BankomatAndKartaTurId,Integer> {
    Optional<BankomatAndKartaTurId> findByBankomatIdAndKartaTuriId(Integer bankomat_id, Integer kartaTuri_id);
}
