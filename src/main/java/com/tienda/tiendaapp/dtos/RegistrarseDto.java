package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class RegistrarseDto {

    private String rol;
    private String nombreCompleto;
    private String correoElectronico;
    private String contraseña;
    private String telefono;
}
