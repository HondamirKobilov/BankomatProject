package com.example.bankomatbeckend.Entity.KartaEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bank  extends Absrakt {

    private String nomi;

    @OneToOne
    private Manzil manzil;





}
