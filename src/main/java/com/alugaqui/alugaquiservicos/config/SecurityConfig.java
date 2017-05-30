package com.alugaqui.alugaquiservicos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("admin").password("admin").roles("CLIENTE", "CORRETOR")
        .and().withUser("corretor").password("corretor").roles("CORRETOR").and().withUser("cliente")
        .password("cliente").roles("CLIENTE");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Disable cross-site request forgery
    http.csrf().disable();

    http.authorizeRequests().antMatchers("/cliente").permitAll().antMatchers("/corretor")
        .permitAll().antMatchers("/buscar-imoveis").permitAll().anyRequest().authenticated();
  }

}
