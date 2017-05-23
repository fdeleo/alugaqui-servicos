package com.alugaqui.alugaquiservicos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Imovel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String bairro;
  private String cidade;
  private String estado;
  private String endereco;
  private String cep;
  private Double area;
  private Integer quartos;
  private Integer banheiros;
  private Integer garagem;
  private Double aluguel;
  private Double condominio;
  private String descricao;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public Double getArea() {
    return area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public Integer getQuartos() {
    return quartos;
  }

  public void setQuartos(Integer quartos) {
    this.quartos = quartos;
  }

  public Integer getBanheiros() {
    return banheiros;
  }

  public void setBanheiros(Integer banheiros) {
    this.banheiros = banheiros;
  }

  public Integer getGaragem() {
    return garagem;
  }

  public void setGaragem(Integer garagem) {
    this.garagem = garagem;
  }

  public Double getAluguel() {
    return aluguel;
  }

  public void setAluguel(Double aluguel) {
    this.aluguel = aluguel;
  }

  public Double getCondominio() {
    return condominio;
  }

  public void setCondominio(Double condominio) {
    this.condominio = condominio;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
