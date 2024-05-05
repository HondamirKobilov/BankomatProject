package com.example.bankomatbeckend.Entity.BankomatEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hisobot extends Absrakt {
    private double summa;
    @CreationTimestamp
    private LocalDateTime toldirilganSana;
    @ManyToOne
    private Xodim xodim;
    @ManyToOne
    private Bankomat bankomat;
}
