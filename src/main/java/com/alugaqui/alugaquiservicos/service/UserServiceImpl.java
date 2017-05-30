package com.alugaqui.alugaquiservicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alugaqui.alugaquiservicos.domain.Usuario;
import com.alugaqui.alugaquiservicos.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService {

  private UsuarioRepository userRepository;

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
    return userRepository.save(user);
  }

}
