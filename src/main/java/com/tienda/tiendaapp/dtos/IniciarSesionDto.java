package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class IniciarSesionDto {

  private String correo;
  private String password;

  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
