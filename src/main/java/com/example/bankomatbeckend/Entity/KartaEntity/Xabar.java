package com.example.bankomatbeckend.Entity.KartaEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xabar extends Absrakt {

    private double yechilganMiqdori;
    private double qolganMiqdor;
    private String sana;

    @OneToOne
    private Users users;

}
