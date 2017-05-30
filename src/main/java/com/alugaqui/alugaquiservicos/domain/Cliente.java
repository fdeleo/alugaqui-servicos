package com.alugaqui.alugaquiservicos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

  private static final long serialVersionUID = 5292626826102032452L;

  @Column(unique = true, nullable = false)
  private String cpf;

  @Override
  protected String getRole() {
    return "ROLE_CLIENTE";
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
