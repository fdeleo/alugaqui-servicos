package com.alugaqui.alugaquiservicos.domain;

import javax.persistence.Entity;

@Entity
public class Corretor extends Usuario {

  private static final long serialVersionUID = 486087235325734139L;

  private String creci;

  @Override
  protected String getRole() {
    return "ROLE_CORRETOR";
  }

  public String getCreci() {
    return creci;
  }

  public void setCreci(String creci) {
    this.creci = creci;
  }

}
