package com.tienda.tiendaapp.dtos;

import lombok.Data;

@Data

public class RegistrarseDto {

    private String rol;
    private String nombreCompleto;
    private String correo;
    private String contraseña;
    private String telefono;
}
