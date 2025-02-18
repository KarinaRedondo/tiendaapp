package com.tienda.tiendaapp.dtos;
import lombok.Data;
import java.util.List;

@Data

public class ActualizarOrdenDto {

    private String idPedido;
    private String fecha;
    private String hora;
    private String estado;
    private int montoTotal;
    private String metodoPago;
    private String direccionEntrega;
    private String cliente;
    private String domiciliario;
    private List<String> productos;
}
