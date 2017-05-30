package com.alugaqui.alugaquiservicos.service;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.alugaqui.alugaquiservicos.domain.Cliente;
import com.alugaqui.alugaquiservicos.domain.Corretor;
import com.alugaqui.alugaquiservicos.domain.Usuario;

public interface UserService extends UserDetailsService {

  public Usuario findByEmail(String email);

  public Usuario create(Usuario user);

  public Collection<Usuario> list();

  public Collection<Cliente> listClientes();

  public Collection<Corretor> listCorretores();

}
