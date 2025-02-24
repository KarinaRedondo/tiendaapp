package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pedidos")

public class Pedido {

    @Id
    private String id;
    private String idCliente;
    private String idTienda;
    private String descripcionPedido;
    private int montoTotal;
    private int precioDomicilio;
    private String estado;
    private String idDomiciliario;
    private String gananciaDomiciliario;
    private String comentariosTendero;
    private String fechaCreacion;
    private String fechaExpiracion;
}
