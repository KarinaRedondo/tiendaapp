package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clientes")

public class Cliente extends Usuario{

    @Id
    private String idCliente;
    private String metodoDePagoPreferido;
    private String direccion;
    private String[] historialDePedidos;
}
