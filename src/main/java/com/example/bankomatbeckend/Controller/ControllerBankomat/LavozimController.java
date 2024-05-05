package com.example.bankomatbeckend.Controller.ControllerBankomat;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.LavozimDto;
import com.example.bankomatbeckend.Service.ServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lavzoim")
public class LavozimController {
    @Autowired
    ServiceImplements serviceImplements;


//    @PreAuthorize(value = "hasAuthority('ADDLAVOZIM')")
    @PostMapping("/lavozimAdd")
    public HttpEntity<?> LavozimAdd(@RequestBody LavozimDto lavozimDto){
        ApiResponse apiResponse=serviceImplements.LavozimAdd(lavozimDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
