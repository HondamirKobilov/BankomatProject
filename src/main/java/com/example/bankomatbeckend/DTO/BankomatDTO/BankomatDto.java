package com.example.bankomatbeckend.DTO.BankomatDTO;
import com.example.bankomatbeckend.Entity.BankomatEntity.Kupyura;
import com.example.bankomatbeckend.Entity.KartaEntity.Bank;
import com.example.bankomatbeckend.Entity.KartaEntity.Manzil;
import lombok.Data;
import java.util.List;
@Data
public class BankomatDto {

    private double maxPulMiqdor;
//    private double balans;
    private double maxPulYechish;
    private double minPulYechish;
    private double hisobotChegara;

    private Manzil manzil;

    private Kupyura kupyura;

    private List<Integer> kartaTuri;

}
