package com.example.bankomatbeckend.Controller.ControllerBankomat;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.KommissiyaDto;
import com.example.bankomatbeckend.Service.ServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kommissiya")
public class KommissiyaController {

    @Autowired
    ServiceImplements serviceImplements;

    @PostMapping("/kommisiya/{bankId}/{kartaTurId}")
    public HttpEntity<?> KommissiyaAdd(@RequestBody KommissiyaDto kommissiyaDto, @PathVariable Integer bankId,@PathVariable Integer kartaTurId){
        ApiResponse apiResponse=serviceImplements.AddKommissiya(kommissiyaDto,bankId,kartaTurId);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());

    }
}
