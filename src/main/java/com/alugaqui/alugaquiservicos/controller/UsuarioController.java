package com.alugaqui.alugaquiservicos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alugaqui.alugaquiservicos.model.Corretor;

@RestController
public class UsuarioController {

  @RequestMapping(value = "/corretor", method = RequestMethod.POST)
  public ResponseEntity<Corretor> criarCorretor(@RequestBody Corretor corretor) {
    return new ResponseEntity<>(corretor, HttpStatus.OK);
  }

}
