package com.example.RegisterLogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

   // private final OAuth2CustomAuthenticationFilter oauth2CustomAuthenticationFilter;

   

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.addFilterBefore(oauth2CustomAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
          http      .authorizeRequests()
                .antMatchers("/home").authenticated()
                .antMatchers("/api/v1/employee/save").permitAll()
                .antMatchers("/api/v1/employee/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }   
}
