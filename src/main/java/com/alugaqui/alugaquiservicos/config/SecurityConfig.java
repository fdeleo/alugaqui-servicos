package com.alugaqui.alugaquiservicos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userService;

  @Autowired
  public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService);
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Disable cross-site request forgery
    http.csrf().disable();

    http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/clientes")
        .hasRole("CLIENTE");
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/clientes").permitAll();

    http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/corretores")
        .hasRole("CORRETOR");
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/corretores").permitAll();

    http.authorizeRequests().antMatchers("/imoveis/busca/**").permitAll();

    http.authorizeRequests().anyRequest().authenticated();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
