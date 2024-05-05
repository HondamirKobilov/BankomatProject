package com.example.bankomatbeckend.DTO.BankomatDTO;

import com.example.bankomatbeckend.Entity.KartaEntity.Manzil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class XodimDto {

    @NotNull(message = "Ismni ,familyani to'ldiring")
    private String fish;
    @NotNull(message = "Usenameni to'ldiring")
    private String username;
    @NotNull(message = "Passwordni to'ldiring")
    private String password;
    @NotNull(message = "Passwordni qaytadan to'ldiring")
    private String repassword;
    @NotNull(message = "TelRaqamni to'ldiring")
    private String telRaqam;
    @NotNull(message = "Manzilni to'ldiring")
    private Manzil manzil;


}
