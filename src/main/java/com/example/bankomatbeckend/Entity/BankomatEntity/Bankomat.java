package com.example.bankomatbeckend.Entity.BankomatEntity;
import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import com.example.bankomatbeckend.Entity.KartaEntity.Bank;
import com.example.bankomatbeckend.Entity.KartaEntity.Manzil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bankomat extends Absrakt {

    @Column(nullable = false)
    private Double maxPulMiqdori;

    @Column(nullable = false)
    private Double balans;

    @Column(nullable = false)
    private Double maxPulYechish;

    @Column(nullable = false)
    private Double minPulYechish;

    @Column(nullable = false)
    private Double hisobotChegara;

    @Column(nullable = false)
    private Double ikkiYuzMing;

    @Column(nullable = false)
    private Double yuzMing;

    @Column(nullable = false)
    private Double ellikMing;

    @Column(nullable = false)
    private Double yigirmaMing;

    @Column(nullable = false)
    private Double onMing;

    @Column(nullable = false)
    private Double beshMing;

    @ManyToOne
    private Bank bank;

    @OneToOne
    private Manzil manzil;
    @OneToOne
    private Xodim xodim;
    @OneToOne
    private Kupyura kupyura;
}
