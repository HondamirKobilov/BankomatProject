package com.example.bankomatbeckend.Entity.BankomatEntity;

import com.example.bankomatbeckend.Entity.Abstrakt.Absrakt;
import com.example.bankomatbeckend.Entity.Enum.Xuquqlar;
import com.example.bankomatbeckend.Entity.KartaEntity.Manzil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xodim extends Absrakt implements UserDetails {

    @Column(nullable = false)
    private String fish;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String telRaqam;

    private String emailKod;

    @ManyToOne
    private Lavozim lavozim;

    @OneToOne
    private Manzil manzil;

    private boolean isAccountNonExpired=true;
    private boolean isAccountNonLocked=true;
    private boolean isCredentialsNonExpired=true;
    private boolean enabled=false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Xuquqlar> xuquqlarList=this.lavozim.getXuquqlarList();
        List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();
        for(Xuquqlar xuquqlar:xuquqlarList){
            grantedAuthorityList.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return xuquqlar.name();
                }
            });
        }
        return grantedAuthorityList;
    }

    public Xodim(String fish, String username, String password, String telRaqam, Lavozim lavozim,boolean enabled) {
        this.fish = fish;
        this.username = username;
        this.password = password;
        this.telRaqam = telRaqam;
        this.lavozim = lavozim;
        this.enabled= enabled;

    }



//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {


//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }




}
