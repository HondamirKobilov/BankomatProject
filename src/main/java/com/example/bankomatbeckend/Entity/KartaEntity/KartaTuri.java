package com.example.bankomatbeckend.Entity.KartaEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class KartaTuri extends Absrakt {

    private Integer id;
    private String  nomi;
    private String boshlanishKodi;


}
