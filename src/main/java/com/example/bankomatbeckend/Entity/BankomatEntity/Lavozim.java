package com.example.bankomatbeckend.Entity.BankomatEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import com.example.bankomatbeckend.Entity.Enum.Xuquqlar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Lavozim extends Absrakt {
    private String nomi;
    private String izoh;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Xuquqlar> xuquqlarList;

}
