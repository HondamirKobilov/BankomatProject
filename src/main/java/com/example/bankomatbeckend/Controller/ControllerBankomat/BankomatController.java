package com.example.bankomatbeckend.Controller.ControllerBankomat;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.BalansDto;
import com.example.bankomatbeckend.DTO.BankomatDTO.BankomatDto;
import com.example.bankomatbeckend.DTO.BankomatDTO.PulQuyishDTO;
import com.example.bankomatbeckend.DTO.BankomatDTO.PulYechishDto;
import com.example.bankomatbeckend.Service.ServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankomat")
public class BankomatController {
    @Autowired
    ServiceImplements serviceImplements;

    @PostMapping("/bankomatAdd/{xodimId}/{bankId}")
    public HttpEntity<?> BankomatAdd(@RequestBody BankomatDto bankomatDto, @PathVariable Integer xodimId, @PathVariable Integer bankId){
        ApiResponse apiResponse=serviceImplements.addBankomat(bankomatDto, xodimId, bankId);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

//    @PostMapping("/balansToldirish/{bankomatId}")
//    public HttpEntity<?> BankomatBalansAdd(@RequestBody BalansDto balansDto, @PathVariable Integer bankomatId){
//        ApiResponse apiResponse=serviceImplements.AddBalansBankomat(balansDto,bankomatId);
//        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
//    }

    @PostMapping("/bankomatdanPulYechish/{bankomatId}")
    public HttpEntity<?> PulYechishBankomat(@PathVariable Integer bankomatId , @RequestBody PulYechishDto pulYechishDto){
        ApiResponse apiResponse=serviceImplements.BankomatPulYechish(bankomatId,pulYechishDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @PutMapping("/BankomatgaPulToldirish/{bankomatId}/{xodimId}")
    public HttpEntity<?> pulQuyish(@RequestBody PulQuyishDTO pulQuyishDto, @PathVariable  Integer bankomatId, @PathVariable Integer xodimId){
        ApiResponse apiResponse=serviceImplements.pulQuyish(bankomatId,xodimId,pulQuyishDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:400).body(apiResponse.getXabar());
    }

    @GetMapping("/readBankomat/{id}")
    public HttpEntity<?> readBankomat(@PathVariable Integer id){
        ApiResponse apiResponse = serviceImplements.readBankomat(id);
        return ResponseEntity.status(apiResponse.isHolat()?200:409).body(apiResponse.getXabar());
    }

    @GetMapping("/korish/{bankomatId}/{xodimId}")
    public HttpEntity<?> korish(@PathVariable Integer bankomatId,@PathVariable Integer xodimId){
        ApiResponse apiResponse=serviceImplements.korish(bankomatId,xodimId);
        return ResponseEntity.status(apiResponse.isHolat()?200:409).body(apiResponse.getXabar());
    }



}
