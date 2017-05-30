package com.alugaqui.alugaquiservicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alugaqui.alugaquiservicos.domain.Cliente;
import com.alugaqui.alugaquiservicos.domain.Corretor;
import com.alugaqui.alugaquiservicos.service.UserService;

@RestController
public class UsuarioController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/corretor", method = RequestMethod.POST)
  public ResponseEntity<Corretor> criarCorretor(@RequestBody Corretor corretor) {
    userService.create(corretor);
    return new ResponseEntity<>(corretor, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/cliente", method = RequestMethod.POST)
  public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
    userService.create(cliente);
    return new ResponseEntity<>(cliente, HttpStatus.CREATED);
  }

}
