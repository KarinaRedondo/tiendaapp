package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EliminarPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public EliminarPedidoServicio(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public boolean elimiarPedido(String id){
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (pedidoOptional.isPresent()){
            pedidoRepositorio.delete(pedidoOptional.get());
            return true;
        }
        else {
            return false;
        }
    }
}
