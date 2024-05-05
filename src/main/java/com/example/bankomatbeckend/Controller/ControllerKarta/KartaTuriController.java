package com.example.bankomatbeckend.Controller.ControllerKarta;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.KartaDTO.BankDto;
import com.example.bankomatbeckend.DTO.KartaDTO.KartaTuriDto;
import com.example.bankomatbeckend.Service.LoyihalashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kartaTuri")
public class KartaTuriController {

    @Autowired
    LoyihalashService loyihalashService;

    @PostMapping("/kartaTuriPost")
    public HttpEntity<?> KartaPost(@RequestBody KartaTuriDto kartaTuriDto){
        ApiResponse apiResponse=loyihalashService.kartaTuriPost(kartaTuriDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

}
