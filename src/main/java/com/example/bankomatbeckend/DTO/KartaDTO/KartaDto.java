package com.example.bankomatbeckend.DTO.KartaDTO;
import lombok.Data;

@Data
public class KartaDto {

//    Karta ma'lumotlari
    private Integer pinKod;
    private String maxsusParoli4;
    private double balans;

//    Users ma'lumotlari
    private String fish;
    private String telRaqam;
    private String email;
    private String passportRaqam;

    private String viloyat;
    private String tuman;
    private String kocha;
}
