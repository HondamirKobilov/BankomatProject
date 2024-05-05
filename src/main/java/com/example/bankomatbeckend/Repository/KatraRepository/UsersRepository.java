package com.example.bankomatbeckend.Repository.KatraRepository;

import com.example.bankomatbeckend.Entity.KartaEntity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
   Optional<Users> findByPassportRaqam(String passportRaqam);
   boolean existsByPassportRaqam(String passportRaqam);

   boolean existsByTelRaqamAndEmail(String telRaqam, String email);

}
