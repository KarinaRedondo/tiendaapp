package com.tienda.tiendaapp.dtos.usuario;

import lombok.Data;

@Data

public class CrearUsuarioDto {

    private String nombreCompleto;
    private String correo;
    private String contraseña;
    private String rol;
    private String activo;
}
