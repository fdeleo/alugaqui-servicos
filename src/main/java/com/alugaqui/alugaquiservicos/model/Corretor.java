package com.alugaqui.alugaquiservicos.model;

import javax.persistence.Entity;

@Entity
public class Corretor extends Usuario {

  private String creci;

  public String getCreci() {
    return creci;
  }

  public void setCreci(String creci) {
    this.creci = creci;
  }

}
