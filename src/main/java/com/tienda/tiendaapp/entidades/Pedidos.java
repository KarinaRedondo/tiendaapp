package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "pedidos")

public class Pedidos {

    @Id
    private String idPedido;
    private String tendero;
    private String observaciones;
    private String descripcionCliente;
    private boolean aceptacionCliente;
    private String fecha;
    private String hora;
    private String estado;
    private int montoTotal;
    private String metodoPago;
    private String direccionEntrega;
    private String cliente;
    private String domiciliario;
}
