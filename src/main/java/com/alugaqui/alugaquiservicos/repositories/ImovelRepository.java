package com.alugaqui.alugaquiservicos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alugaqui.alugaquiservicos.model.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, Long> {

  List<Imovel> findByBairroOrCidadeOrEstado(String bairro, String cidade, String estado);

}
