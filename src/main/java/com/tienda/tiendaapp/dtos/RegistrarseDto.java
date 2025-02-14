package com.tienda.tiendaapp.dtos;
import com.tienda.tiendaapp.entidades.Role;
import lombok.Data;

@Data

public class RegistrarseDto {

    private Role rol;
    private String nombreCompleto;
    private String correoElectronico;
    private String contraseña;
    private String telefono;
}
