package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.dtos.pedido.CrearPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CrearPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public CrearPedidoServicio(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido crearPedido(CrearPedidoDto crearPedidoDto){

        Pedido pedido = new Pedido();
        pedido.setIdCliente(crearPedidoDto.getIdCliente());
        pedido.setIdTienda(crearPedidoDto.getIdTienda());
        pedido.setDescripcionPedido(crearPedidoDto.getDescripcionPedido());
        pedido.setMontoTotal(crearPedidoDto.getMontoTotal());
        pedido.setPrecioDomicilio(crearPedidoDto.getPrecioDomicilio());
        pedido.setEstado(crearPedidoDto.getEstado());
        pedido.setIdDomiciliario(crearPedidoDto.getIdDomiciliario());
        pedido.setGananciaDomiciliario(crearPedidoDto.getGananciaDomiciliario());
        pedido.setComentariosTendero(crearPedidoDto.getComentariosTendero());
        pedido.setFechaCreacion(crearPedidoDto.getFechaCreacion());
        pedido.setFechaEntrega(crearPedidoDto.getFechaEntrega());
        pedido.setFechaExpiracion(crearPedidoDto.getFechaExpiracion());

        return pedidoRepositorio.save(pedido);
    }
}

