package com.oauth2.eassessment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        var niklasHohlweg = User
                .withUsername("niklasHohlweg")
                .password("12345")
                .authorities(Roles.ADMIN.getString())
                .build();

        var xavierBerndt = User
                .withUsername("xavierBerndt")
                .password("12345")
                .authorities(Roles.LECTURER.getString())
                .build();

        var philippBolle = User
                .withUsername("philippBolle")
                .password("12345")
                .authorities(Roles.STUDENT.getString())
                .build();

        var raymondBimazubute = User
                .withUsername("raymondBimazubute")
                .password("12345")
                .authorities(Roles.LECTURER.getString())
                .build();

        var udm = new InMemoryUserDetailsManager();
        udm.createUser(niklasHohlweg);
        udm.createUser(xavierBerndt);
        udm.createUser(philippBolle);
        udm.createUser(raymondBimazubute);

        return udm;

    };

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();

    };

}
