package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.dtos.pedido.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ActualizarPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ActualizarPedidoServicio(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido actualizarPedido(ActualizarPedidoDto actualizarPedidoDto) {
        List<Pedido> listaDePedidos = pedidoRepositorio.findAll();
        Pedido pedidoEncontrado = null;

        for (Pedido pedido : listaDePedidos) {
            if (pedido.getId().equals(actualizarPedidoDto.getId())) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        if (pedidoEncontrado != null) {
            pedidoEncontrado.setId(actualizarPedidoDto.getId());
            pedidoEncontrado.setIdCliente(actualizarPedidoDto.getIdCliente());
            pedidoEncontrado.setIdTienda(actualizarPedidoDto.getIdTienda());
            pedidoEncontrado.setDescripcionPedido(actualizarPedidoDto.getDescripcionPedido());
            pedidoEncontrado.setMontoTotal(actualizarPedidoDto.getMontoTotal());
            pedidoEncontrado.setPrecioDomicilio(actualizarPedidoDto.getPrecioDomicilio());
            pedidoEncontrado.setEstado(actualizarPedidoDto.getEstado());
            pedidoEncontrado.setIdDomiciliario(actualizarPedidoDto.getIdDomiciliario());
            pedidoEncontrado.setGananciaDomiciliario(actualizarPedidoDto.getGananciaDomiciliario());
            pedidoEncontrado.setComentariosTendero(actualizarPedidoDto.getComentariosTendero());
            pedidoEncontrado.setFechaCreacion(actualizarPedidoDto.getFechaCreacion());
            pedidoEncontrado.setFechaExpiracion(actualizarPedidoDto.getFechaExpiracion());

            return pedidoRepositorio.save(pedidoEncontrado);
        }
        else {
            return null;
        }
    }
}
