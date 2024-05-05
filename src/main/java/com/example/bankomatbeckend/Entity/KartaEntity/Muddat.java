package com.example.bankomatbeckend.Entity.KartaEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Muddat extends Absrakt {
     private Integer muddati;

     @ManyToOne
     private  Bank bank;

     @ManyToOne
     private KartaTuri kartaTuri;


}
