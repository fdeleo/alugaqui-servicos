package com.alugaqui.alugaquiservicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alugaqui.alugaquiservicos.model.Cliente;
import com.alugaqui.alugaquiservicos.model.Corretor;
import com.alugaqui.alugaquiservicos.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepo;

  @RequestMapping(value = "/corretor", method = RequestMethod.POST)
  public ResponseEntity<Corretor> criarCorretor(@RequestBody Corretor corretor) {
    usuarioRepo.save(corretor);
    return new ResponseEntity<>(corretor, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/cliente", method = RequestMethod.POST)
  public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
    usuarioRepo.save(cliente);
    return new ResponseEntity<>(cliente, HttpStatus.CREATED);
  }

}
