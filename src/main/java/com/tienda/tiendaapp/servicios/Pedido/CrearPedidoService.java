package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.dtos.CrearPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearPedidoService {
    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public CrearPedidoService(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido crearPedido(CrearPedidoDto crearPedidoDto) {

        Pedido pedidos = new Pedido();
        pedidos.setTendero(crearPedidoDto.getTendero());
        pedidos.setObservaciones(crearPedidoDto.getObservaciones());
        pedidos.setDescripcionCliente(crearPedidoDto.getDescripcionCliente());
        pedidos.setAceptacionCliente(crearPedidoDto.isAceptacionCliente());
        pedidos.setFecha(crearPedidoDto.getFecha());
        pedidos.setHora(crearPedidoDto.getHora());
        pedidos.setEstado(crearPedidoDto.getEstado());
        pedidos.setMontoTotal(crearPedidoDto.getMontoTotal());
        pedidos.setMetodoPago(crearPedidoDto.getMetodoPago());
        pedidos.setDireccionEntrega(crearPedidoDto.getDireccionEntrega());
        pedidos.setCliente(crearPedidoDto.getCliente());
        pedidos.setDomiciliario(crearPedidoDto.getDomiciliario());

        return pedidoRepositorio.save(pedidos);
    }

}
