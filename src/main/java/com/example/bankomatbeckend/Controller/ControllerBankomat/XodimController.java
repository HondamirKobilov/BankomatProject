package com.example.bankomatbeckend.Controller.ControllerBankomat;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.XodimDto;
import com.example.bankomatbeckend.DTO.LoginDto;
import com.example.bankomatbeckend.Service.LoyihalashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/xodim")
public class XodimController {
    @Autowired
    LoyihalashService loyihalashService;

    @PostMapping("/registr")
    public HttpEntity<?> XodimAdd(@RequestBody XodimDto xodimDto){
        ApiResponse apiResponse =loyihalashService.xodimRegistor(xodimDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/tasdiqlash")
    public HttpEntity<?> Tasdiqlash(@RequestParam String email, @RequestParam String emailkod){
        ApiResponse apiResponse=loyihalashService.Faollashtirish(email, emailkod);
        return ResponseEntity.status(apiResponse.isHolat()? 200: 409).body(apiResponse.getXabar());
    }
    @PostMapping("/xodimlogin")
    public HttpEntity<?> XodimLogin(@Valid @RequestBody LoginDto loginDto){
        ApiResponse apiResponse=loyihalashService.XodimLogin(loginDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

}
