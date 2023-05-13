package com.blogapplication.blogapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    

    @Bean
    public static PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {

        httpSecurity.csrf().disable()
            .authorizeHttpRequests( (authorize) -> authorize.anyRequest().authenticated()
            ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails mohosin = User.builder()
                                .username("mohosin")
                                .password(passwordEncoder().encode("mohosin"))
                                .roles("USER")
                                .build();

        UserDetails admin = User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(mohosin, admin);
    }


}
