package com.example.bankomatbeckend.Entity.KartaEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users extends Absrakt {


    private String fish;
    @Column(unique = true)
    private String telRaqam;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String passportRaqam;

    @OneToOne
    private Manzil manzil;


}
