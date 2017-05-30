package com.alugaqui.alugaquiservicos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Corretor extends Usuario {

  @Column(unique = true, nullable = false)
  private String creci;

  public String getCreci() {
    return creci;
  }

  public void setCreci(String creci) {
    this.creci = creci;
  }

}
