package com.example.bankomatbeckend.Controller.ControllerKarta;

import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.KartaDTO.MuddatDto;
import com.example.bankomatbeckend.Entity.KartaEntity.Bank;
import com.example.bankomatbeckend.Service.LoyihalashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muddat")
public class MuddatController {
    @Autowired
    LoyihalashService loyihalashService;

    @PostMapping("/addMuddat/{bankId}/{kartaTuriId}")
    public HttpEntity<?> muddatAdd(@RequestBody MuddatDto muddatDto, @PathVariable Integer bankId,@PathVariable Integer kartaTuriId){
        ApiResponse apiResponse=loyihalashService.addMuddat(muddatDto,bankId,kartaTuriId);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
