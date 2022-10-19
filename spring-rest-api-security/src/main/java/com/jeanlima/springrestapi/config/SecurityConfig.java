package com.jeanlima.springrestapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jeanlima.springrestapi.security.JwtAuthFilter;
import com.jeanlima.springrestapi.security.JwtService;
import com.jeanlima.springrestapi.service.impl.UsuarioServiceImpl;

@EnableWebSecurity //configuracao de segurança
public class SecurityConfig {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Bean
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService, usuarioService);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() //seguranca entre aplicavao web e api,aqui nossa api é rest
            .authorizeHttpRequests((authz) -> {
                try {
                    authz
                        .antMatchers("/api/clientes/**")
                            //.hasRole("USER") 
                            .hasAnyRole("USER","ADMIN")
                        .antMatchers("/api/produtos/**")
                            .hasRole("ADMIN")
                        .antMatchers("/api/pedidos/**")
                            //.hasRole("USER")    
                            .hasAnyRole("USER","ADMIN") 
                        .antMatchers(HttpMethod.POST, "/api/usuarios/**")
                            .permitAll()
                        .anyRequest().authenticated()   
                    .and() 
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //sessões sem usuários - TODA REQUISICAO PRECISA DO TOKEN
                    .and() //volta a raiz
                        .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                
                 
            );
            //.formLogin();
            //.httpBasic(); //possibilita "logar" com o headers de autenticação
            
             //formulario de login customizado
            //.httpBasic(withDefaults());
        return http.build();
    }




    
}
