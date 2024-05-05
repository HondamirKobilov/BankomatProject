package com.example.bankomatbeckend.Repository.BankomatRepository;

import com.example.bankomatbeckend.Entity.BankomatEntity.Lavozim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LavozimRepository extends JpaRepository<Lavozim,Integer> {
    Optional<Lavozim> findByNomi(String nomi);

    boolean existsByNomi(String nomi);


}
