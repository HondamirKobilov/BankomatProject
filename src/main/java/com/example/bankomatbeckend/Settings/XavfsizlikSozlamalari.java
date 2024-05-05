package com.example.bankomatbeckend.Settings;
import com.example.bankomatbeckend.Service.ServiceImplements;
import com.example.bankomatbeckend.Token.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Properties;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class XavfsizlikSozlamalari extends WebSecurityConfigurerAdapter {
    @Autowired
    ServiceImplements serviceImplements;
    @Autowired
    Filter filter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/bank/bankPost","/kartaTuri/kartaTuriPost").permitAll()
                .antMatchers("/muddat/addMuddat/{{bankId}}/{{kartaTuriId}}").permitAll()
                .antMatchers("/karta/kartaPost/{{bankId}}/{{kartaTuriId}}/{{muddatId}}").permitAll()
                .antMatchers("/karta/kartaBalans").permitAll()
                .antMatchers("/users/joylash/{{bankId}}/{{kartaTuriId}}/{{muddatId}}").permitAll()
                .antMatchers("/karta/kartaAdd/{{muddatId}}").permitAll()
                .antMatchers("/xodim/tasdiqlash","/xodim/xodimlogin").permitAll()
                .antMatchers("/xodim/registr").permitAll()
                .antMatchers("/kommissiya/kommisiya/{{bankId}}/{{kartaTurId}}").permitAll()
                .antMatchers("/kupuyra/kupuyaAdd","/kupuyra/kupuryaEdit/{{id}}","/kupuyra/kupuyraRead").permitAll()
                .antMatchers("/bankomat/bankomatAdd/{xodimId}/{bankId}").permitAll()
                .antMatchers("/bankomat/balansToldirish/{{bankomatId}}").permitAll()
                .antMatchers("/bankomat/bankomatdanPulYechish/{{bankomatId}}").permitAll()
                .antMatchers("/bankomat/korish/{bankomatId}/{xodimId}").permitAll()
                .antMatchers("/bankomat/BankomatgaPulToldirish/{bankomatId}/{xodimId}").permitAll()
                .antMatchers("/bankomat/readBankomat/{id}").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .disable();
        http
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("hondamirkobilov02@gmail.com");
        mailSender.setPassword("vwyapenimplnwxiy");
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug","true");
        return mailSender;

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(serviceImplements)
                .passwordEncoder(passwordEncoder());

    }



}
