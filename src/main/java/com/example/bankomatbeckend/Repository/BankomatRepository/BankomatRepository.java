package com.example.bankomatbeckend.Repository.BankomatRepository;

import com.example.bankomatbeckend.Entity.BankomatEntity.Bankomat;
import com.example.bankomatbeckend.Entity.KartaEntity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankomatRepository extends JpaRepository<Bankomat,Integer> {

  Bank findByBankId(Integer bank_id);

  Optional<Bankomat> findByBankNomi(String bankNomi);

  Optional<Bankomat> findByIdAndXodimId(Integer id, Integer xodim_id);
}
