package com.example.bankomatbeckend.Entity.Abstrakt;

import com.example.bankomatbeckend.Entity.BankomatEntity.Lavozim;
import com.example.bankomatbeckend.Entity.BankomatEntity.Xodim;
import com.example.bankomatbeckend.Entity.Enum.Xuquqlar;
import com.example.bankomatbeckend.Repository.BankomatRepository.LavozimRepository;
import com.example.bankomatbeckend.Repository.BankomatRepository.XodimRepository;
import com.example.bankomatbeckend.Repository.ManzilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.bankomatbeckend.Entity.Enum.Xuquqlar.*;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    LavozimRepository lavozimRepository;

     @Autowired
     PasswordEncoder passwordEncoder;

    @Autowired
    XodimRepository xodimRepository;

    @Autowired
    ManzilRepository manzilRepository;

    @Value(value ="${spring.sql.init.mode}")
    private String boshlangichBoshqaruv;

    @Override
    public void run(String... args) throws Exception {
        if(boshlangichBoshqaruv.equals("always")){
            Xuquqlar[] xuquqlars = Xuquqlar.values();
            Lavozim direktor= lavozimRepository.save(new Lavozim(LavozimConstanta.DIREKTOR, "Bank boshlig'i", Arrays.asList(xuquqlars)));
            Lavozim xodim = lavozimRepository.save(new Lavozim(LavozimConstanta.XODIM, "direktor yordamchisi", Arrays.asList(READXISOBAT,ADDBALANS, EDITBALANS, DELETEBALANS, READBALANS, KUPUYRAADD,KUPUYRAEDIT, KUPUYRAREAD)));
            xodimRepository.save(new Xodim("Hondamir Kobilov ","hondamirkobilov02@gmail.com",passwordEncoder.encode("xondamir02"),"+998997796202",direktor,true));
            xodimRepository.save(new Xodim("Doston Bozorov","bozorov323@gmail.com",passwordEncoder.encode("doston002"),"+998995562334",xodim,true));

        }
    }
}
