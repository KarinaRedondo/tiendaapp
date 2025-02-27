package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AsignarDomiciliarioAlPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public AsignarDomiciliarioAlPedidoServicio(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Optional<Pedido> asignarDomiciliario(String id, String idDomiciliario) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setId(idDomiciliario);
            pedidoRepositorio.save(pedido);

            return Optional.of(pedido);
        }
        return Optional.empty();
    }
}
