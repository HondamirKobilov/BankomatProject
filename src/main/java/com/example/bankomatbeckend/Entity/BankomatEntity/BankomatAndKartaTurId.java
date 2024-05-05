package com.example.bankomatbeckend.Entity.BankomatEntity;
import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import com.example.bankomatbeckend.Entity.KartaEntity.KartaTuri;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BankomatAndKartaTurId extends Absrakt {

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Bankomat bankomat;

    @ManyToOne
    private KartaTuri kartaTuri;

}
