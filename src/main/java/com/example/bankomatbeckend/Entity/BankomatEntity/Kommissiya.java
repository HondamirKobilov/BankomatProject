package com.example.bankomatbeckend.Entity.BankomatEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import com.example.bankomatbeckend.Entity.KartaEntity.Bank;
import com.example.bankomatbeckend.Entity.KartaEntity.KartaTuri;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Kommissiya extends Absrakt {
    private double foiz;

    @ManyToOne
    private Bank bank;

    @OneToOne
    private KartaTuri kartaTuri;


}
