package com.example.bankomatbeckend.DTO.BankomatDTO;

import com.example.bankomatbeckend.Entity.Enum.Xuquqlar;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.List;

@Data
public class LavozimDto {
    private String nomi;
    private String izoh;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Xuquqlar> xuquqlarList;
}
