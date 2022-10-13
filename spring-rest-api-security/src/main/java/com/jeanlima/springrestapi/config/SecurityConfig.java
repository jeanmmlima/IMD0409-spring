package com.jeanlima.springrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //configuracao de segurança
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){

        /*
        PasswordEncoder passwordEncoder = new PasswordEncoder() {
             //codiica a senha
            @Override
            public String encode(CharSequence rawPassword) {
                // TODO Auto-generated method stub
                return rawPassword + "321";
            }

            //descodifca a senha
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // TODO Auto-generated method stub
                return (rawPassword + "321").equals(encodedPassword);
            } 
            };*/
            return new BCryptPasswordEncoder();

    
            
    };

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
            .withUsername("fulano")
            .password(passwordEncoder().encode("123"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() //seguranca entre aplicavao web e api,aqui nossa api é rest
            .authorizeHttpRequests((authz) -> authz
                .antMatchers("/api/clientes/**").authenticated() //precisa estar autenticado
                //.antMatchers("/api/clientes/**").permitAll() //vai permitir todos
                //.antMatchers("/api/clientes/**").hasRole("USER")
                
                 
            )
            //.formLogin();
            
             //formulario de login customizado
            .httpBasic();
        return http.build();
    }




    
}
