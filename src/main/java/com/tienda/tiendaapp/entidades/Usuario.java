package com.tienda.tiendaapp.entidades;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
@Getter

public class Usuario {

    @Id
    private String id;
    private String rol;
    private String nombreCompleto;
    private String correoElectronico;
    private String contraseña;
    private String telefono;

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public String getContraseña() {
        return contraseña;
    }
}
