package com.alugaqui.alugaquiservicos.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alugaqui.alugaquiservicos.domain.Cliente;
import com.alugaqui.alugaquiservicos.domain.Corretor;
import com.alugaqui.alugaquiservicos.domain.Usuario;
import com.alugaqui.alugaquiservicos.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService {

  private UsuarioRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UsuarioRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario user = findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return user;
  }

  @Override
  public Usuario findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public Usuario create(Usuario user) {
    String unencryptedPassword = user.getSenha();
    user.setSenha(passwordEncoder.encode(unencryptedPassword));
    return userRepository.save(user);
  }

  @Override
  public Collection<Usuario> list() {
    Collection<Usuario> list = new ArrayList<>();
    userRepository.findAll().forEach(list::add);
    return list;
  }

  @Override
  public Collection<Cliente> listClientes() {
    Collection<Cliente> clientes = new ArrayList<>();
    for (Usuario user : list()) {
      if (user instanceof Cliente)
        clientes.add((Cliente) user);
    }
    return clientes;
  }

  @Override
  public Collection<Corretor> listCorretores() {
    Collection<Corretor> corretores = new ArrayList<>();
    for (Usuario user : list()) {
      if (user instanceof Corretor)
        corretores.add((Corretor) user);
    }
    return corretores;
  }

}
