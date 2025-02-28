package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FiltrarPedidosPorEstadoServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public FiltrarPedidosPorEstadoServicio(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public List<Pedido> obtenerPedidosPorEstado(String estado) {
        return pedidoRepositorio.findByEstado(estado);
    }

    public List<Pedido> obtenerPedidosClientePorEstado(String idCliente, String estado) {
        return pedidoRepositorio.findByIdClienteAndEstado(idCliente, estado);
    }

    public List<Pedido> obtenerPedidosTiendaPorEstado(String idTienda, String estado){
        return pedidoRepositorio.findByIdTiendaAndEstado(idTienda, estado);
    }
}
