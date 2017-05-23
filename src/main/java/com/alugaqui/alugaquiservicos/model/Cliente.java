package com.alugaqui.alugaquiservicos.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
