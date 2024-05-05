package com.example.bankomatbeckend.Service;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.*;
import com.example.bankomatbeckend.DTO.KartaDTO.*;
import com.example.bankomatbeckend.DTO.LoginDto;
import com.example.bankomatbeckend.Entity.BankomatEntity.Bankomat;

public interface LoyihalashService {
    ApiResponse postBank(BankDto bankDto);

    ApiResponse kartaTuriPost(KartaTuriDto kartaTuriDto);

    ApiResponse kartaPost(KartaDto kartaDto, Integer bankId, Integer kartaTuriId, Integer muddatId);

    ApiResponse addMuddat(MuddatDto muddatDto, Integer bankId, Integer kartaTuriId);


    ApiResponse kartaAdd(KartaMijozDto kartaMijozDto, Integer muddatId);

    ApiResponse xodimRegistor(XodimDto xodimDto);

    ApiResponse Faollashtirish(String email, String emailkod);

    ApiResponse XodimLogin(LoginDto loginDto);

    ApiResponse LavozimAdd(LavozimDto lavozimDto);


    ApiResponse AddKommissiya(KommissiyaDto kommissiyaDto, Integer bankId, Integer kartaTurId);

    ApiResponse KupuraSoniAdd(KupuyraDto kupuyraDto);


    ApiResponse KupuraSoniEdit(KupuyraDto kupuyraDto, Integer id, Integer xodimId, Integer bankomatId);

    ApiResponse addBankomat(BankomatDto bankomatDto, Integer xodimId, Integer bankId);

    ApiResponse KartaBalansAdd(BalansKartaDto balansKartaDto);


    ApiResponse BankomatPulYechish(Integer bankomatId, PulYechishDto pulYechishDto);

    ApiResponse korish(Integer bankomatId, Integer xodimId);

    ApiResponse readBankomat(Integer id);
}
