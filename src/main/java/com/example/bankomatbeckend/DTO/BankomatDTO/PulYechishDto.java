package com.example.bankomatbeckend.DTO.BankomatDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PulYechishDto {
    private String maxsusRaqam;
    private Integer pinKod;

    private double summa;
    private LocalDate muddat;
}
