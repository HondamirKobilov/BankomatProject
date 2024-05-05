package com.example.bankomatbeckend.Entity.KartaEntity;
import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Karta extends Absrakt {

    private Integer id;

    private String maxsusRaqam;

    private Integer pinKod;

    private double balans;

    @OneToOne
    private KartaTuri katraTuri;

    @OneToOne
    private Users users;

    @ManyToOne
    private Bank bank;

    private LocalDate muddat;
}
