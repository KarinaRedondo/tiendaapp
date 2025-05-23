package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ListarPedidosServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ListarPedidosServicio(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public List<Pedido> ListarPedidos(){
        return pedidoRepositorio.findAll();
    }
}
