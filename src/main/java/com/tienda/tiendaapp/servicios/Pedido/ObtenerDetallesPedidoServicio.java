package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ObtenerDetallesPedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public Optional<Pedido> obtenerDetallesPedidoPorId(String id) {
        return pedidoRepositorio.findById(id);
    }
}
