package com.example.bankomatbeckend.Controller.ControllerBankomat;
import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.KupuyraDto;
import com.example.bankomatbeckend.Repository.BankomatRepository.KupuyraRepository;
import com.example.bankomatbeckend.Service.ServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/kupuyra")
public class KupyuraController {

    @Autowired
    ServiceImplements serviceImplements;

    @Autowired
    KupuyraRepository kupuyraRepository;

    @PostMapping("/kupuyaAdd")
    public HttpEntity<?> Kupuyra(@RequestBody KupuyraDto kupuyraDto){
        ApiResponse apiResponse=serviceImplements.KupuraSoniAdd(kupuyraDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @PutMapping("/kupuryaEdit/{id}")
    public HttpEntity<?> KupuyraEdit(@RequestBody KupuyraDto kupuyraDto,@PathVariable Integer id, @PathVariable Integer xodimId, @PathVariable Integer bankomatId){
        ApiResponse apiResponse=serviceImplements.KupuraSoniEdit(kupuyraDto,id,xodimId,bankomatId);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @GetMapping("/kupuyraRead")
    public HttpEntity<?> KupuyraRead(){
       return ResponseEntity.ok(kupuyraRepository.findAll());
    }



}
