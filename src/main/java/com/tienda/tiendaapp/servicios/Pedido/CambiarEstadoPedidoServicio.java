package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CambiarEstadoPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public CambiarEstadoPedidoServicio(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Optional<Pedido> actualizarEstado(String id, String nuevoEstado) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setEstado(nuevoEstado);
            pedidoRepositorio.save(pedido);

            return Optional.of(pedido);
        }
        return Optional.empty();
    }
}
