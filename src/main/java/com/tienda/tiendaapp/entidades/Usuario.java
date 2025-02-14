package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")

public class Usuario {

    @Id
    private String id;
    private Role rol;
    private String nombreCompleto;
    private String correoElectronico;
    private String contraseña;
    private String telefono;
}
