package com.example.bankomatbeckend.Entity.BankomatEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Kupyura extends Absrakt {
    private Double ming200;
    private Double ming100;
    private Double ming50;
    private Double ming20;
    private Double ming10;
    private Double ming5;
}
