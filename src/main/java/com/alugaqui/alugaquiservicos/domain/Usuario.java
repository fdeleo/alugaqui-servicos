package com.alugaqui.alugaquiservicos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public abstract class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true, nullable = false)
  private String email;
  @Column(nullable = false)
  private String senha;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String sobrenome;
  private String celular;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

}
