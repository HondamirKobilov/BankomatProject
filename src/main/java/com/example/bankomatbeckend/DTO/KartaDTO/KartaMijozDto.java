package com.example.bankomatbeckend.DTO.KartaDTO;

import com.example.bankomatbeckend.Entity.Enum.MijozStatus;
import com.example.bankomatbeckend.Entity.KartaEntity.Manzil;
import com.example.bankomatbeckend.Entity.KartaEntity.Users;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
public class KartaMijozDto {
    private Integer pinKod;
    private Users users;
    private Manzil manzil;
    private MijozStatus mijozStatus;
}
