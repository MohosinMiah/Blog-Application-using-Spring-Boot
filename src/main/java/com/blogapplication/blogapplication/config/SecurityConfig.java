package com.blogapplication.blogapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
 
    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
    {

        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        // httpSecurity.csrf().disable()
        //     .authorizeHttpRequests( (authorize) -> 
        //         authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
        //         .requestMatchers("/api/auth/**").permitAll()
        //         .anyRequest().authenticated()
        //     );

        http.csrf().disable()
        .authorizeHttpRequests( requests -> requests
            .requestMatchers(HttpMethod.GET,  "/api/**").authenticated()
            .requestMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic();
        return http.build();
    }

   


    // This function is not required for Database Authentication this is just required for create Inmemoery Users
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails mohosin = User.builder()
    //                             .username("mohosin")
    //                             .password(passwordEncoder().encode("mohosin"))
    //                             .roles("USER")
    //                             .build();

    //     UserDetails admin = User.builder()
    //                     .username("admin")
    //                     .password(passwordEncoder().encode("admin"))
    //                     .roles("ADMIN")
    //                     .build();

    //     return new InMemoryUserDetailsManager(mohosin, admin);
    // }


}
