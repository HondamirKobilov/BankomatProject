package com.example.bankomatbeckend.Repository.BankomatRepository;

import com.example.bankomatbeckend.Entity.BankomatEntity.Xodim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface XodimRepository extends JpaRepository<Xodim,Integer> {
  boolean existsByUsername(String username);
  boolean existsByTelRaqam(String telRaqam);
  Optional<Xodim> findByUsernameAndEmailKod(String username, String emailKod);
  Optional<Xodim> findByUsername(String username);
}
