package com.alugaqui.alugaquiservicos.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.alugaqui.alugaquiservicos.domain.Usuario;

public interface UserService extends UserDetailsService {

  public Usuario findByEmail(String email);

  public Usuario create(Usuario user);

}
