package com.tienda.tiendaapp.entidades;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")

public class Usuario {

    @Id
    private String id;
    private String nombreCompleto;
    private String correo;
    private String contraseña;
    private String rol;
    private String activo;
}
