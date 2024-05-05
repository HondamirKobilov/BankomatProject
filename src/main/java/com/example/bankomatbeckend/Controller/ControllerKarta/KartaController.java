package com.example.bankomatbeckend.Controller.ControllerKarta;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.KartaDTO.*;
import com.example.bankomatbeckend.Entity.KartaEntity.Users;
import com.example.bankomatbeckend.Repository.KatraRepository.UsersRepository;
import com.example.bankomatbeckend.Service.LoyihalashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/karta")
public class KartaController {

    @Autowired
    LoyihalashService loyihalashService;

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/kartaPost/{bankId}/{kartaTuriId}/{muddatId}")
    public HttpEntity<?> KartaPost( @RequestBody KartaDto kartaDto, @PathVariable Integer bankId,@PathVariable Integer kartaTuriId,@PathVariable Integer muddatId){
        ApiResponse apiResponse=loyihalashService.kartaPost(kartaDto,bankId,kartaTuriId,muddatId);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @PostMapping("/passportRaqam")
    public HttpEntity<?> PassportRaqam(@RequestBody PassportRaqamDto passportRaqamDto){
        Optional<Users> byPassportRaqam = usersRepository.findByPassportRaqam(passportRaqamDto.getPassportRaqam());
        if(byPassportRaqam.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(byPassportRaqam.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mijoz ro'yhatdan o'tmagan");
    }

    @PostMapping("/kartaAdd/{muddatId}")
    public HttpEntity<?> KartaAdd(@RequestBody KartaMijozDto kartaMijozDto, @PathVariable Integer muddatId){
        ApiResponse apiResponse=loyihalashService.kartaAdd(kartaMijozDto,muddatId);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @PostMapping("/kartaBalans")
    public HttpEntity<?> KartaBalansAdd(@RequestBody BalansKartaDto balansKartaDto){
        ApiResponse apiResponse=loyihalashService.KartaBalansAdd(balansKartaDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }


}
