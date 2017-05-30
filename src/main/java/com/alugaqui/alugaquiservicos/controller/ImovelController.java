package com.alugaqui.alugaquiservicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alugaqui.alugaquiservicos.model.Imovel;
import com.alugaqui.alugaquiservicos.repositories.ImovelRepository;

@RestController
public class ImovelController {

  @Autowired
  private ImovelRepository imovelRepo;

  @RequestMapping(value = "/buscar-imoveis", method = RequestMethod.GET)
  public ResponseEntity<List<Imovel>> criarCorretor(@RequestParam("busca") String busca) {
    List<Imovel> imoveis = imovelRepo.findByBairroOrCidadeOrEstado(busca, busca, busca);
    return new ResponseEntity<>(imoveis, HttpStatus.OK);
  }

}
