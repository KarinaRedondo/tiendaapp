package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EliminarPedidoService {
    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public EliminarPedidoService(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }
    public boolean eliminarPedido(String idPedido){
        Optional<Pedido> pedidosOptional = pedidoRepositorio.findById(idPedido);

        if (pedidosOptional.isPresent()){
            pedidoRepositorio.delete(pedidosOptional.get());
            return true;
        }else {
            return false;
        }
    }
}
