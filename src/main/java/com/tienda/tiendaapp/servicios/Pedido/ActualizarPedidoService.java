package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.dtos.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualizarPedidoService {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ActualizarPedidoService(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }
    public Pedido actualizarPedido(ActualizarPedidoDto actualizarPedidoDto){
        List<Pedido> ListaDePedidos = pedidoRepositorio.findAll();
        Pedido pedidoEcontrado = null;

        for (Pedido pedido : ListaDePedidos){
            if (pedido.getIdPedido().equals(actualizarPedidoDto.getIdPedido())){
                pedidoEcontrado = pedido;
                break;
            }
        }
        if (pedidoEcontrado != null){
            pedidoEcontrado.setTendero(actualizarPedidoDto.getTendero());
            pedidoEcontrado.setObservaciones(actualizarPedidoDto.getObservaciones());
            pedidoEcontrado.setDescripcionCliente(actualizarPedidoDto.getDescripcionCliente());
            pedidoEcontrado.setAceptacionCliente(actualizarPedidoDto.isAceptacionCliente());
            pedidoEcontrado.setFecha(actualizarPedidoDto.getFecha());
            pedidoEcontrado.setHora(actualizarPedidoDto.getHora());
            pedidoEcontrado.setEstado(actualizarPedidoDto.getEstado());
            pedidoEcontrado.setMontoTotal(actualizarPedidoDto.getMontoTotal());
            pedidoEcontrado.setMetodoPago(actualizarPedidoDto.getMetodoPago());
            pedidoEcontrado.setDireccionEntrega(actualizarPedidoDto.getDireccionEntrega());
            pedidoEcontrado.setCliente(actualizarPedidoDto.getCliente());
            pedidoEcontrado.setDomiciliario(actualizarPedidoDto.getDomiciliario());

            return pedidoRepositorio.save(pedidoEcontrado);
        }else {
            return null;
        }
    }

}
