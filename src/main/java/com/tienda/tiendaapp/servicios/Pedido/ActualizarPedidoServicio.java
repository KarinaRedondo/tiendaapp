package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.entidades.*;
import com.tienda.tiendaapp.dtos.pedido.ActualizarPedidoDto;
import com.tienda.tiendaapp.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActualizarPedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;

    @Autowired
    private GananciaTiendaRepositorio gananciaTiendaRepositorio;

    public Pedido actualizarPedido(ActualizarPedidoDto dto) {

        Pedido pedido = pedidoRepositorio.findById(dto.getId()).orElse(null);

        if (pedido == null) {
            System.out.println("No se encontró el pedido con ID: " + dto.getId());
            return null;
        }


        String estadoAnterior = pedido.getEstado();

        // Actualizar los datos del pedido
        pedido.setEstado(dto.getEstado());
        pedido.setIdDomiciliario(dto.getIdDomiciliario());
        pedido.setGananciaDomiciliario(dto.getGananciaDomiciliario());
        pedido.setFechaEntrega(dto.getFechaEntrega());


        // Verificar si el estado cambió a "entregado"
        if (dto.getEstado().equals("entregado") && !estadoAnterior.equals("entregado")) {

            // Registrar ganancia del domiciliario
            GananciaDomiciliario nuevaGanancia = new GananciaDomiciliario();
            nuevaGanancia.setIdDomiciliario(pedido.getIdDomiciliario());
            nuevaGanancia.setIdPedido(pedido.getId());
            nuevaGanancia.setGananciaDiaria(pedido.getGananciaDomiciliario());
            nuevaGanancia.setFechaEntrega(pedido.getFechaEntrega());
            gananciaDomiciliarioRepositorio.save(nuevaGanancia);

            // Registrar ganancia de la tienda
            GananciaTienda gananciaTienda = new GananciaTienda();
            gananciaTienda.setIdTienda(pedido.getIdTienda());
            gananciaTienda.setIdPedido(pedido.getId());
            gananciaTienda.setMonto(pedido.getMontoTotal());
            gananciaTienda.setFechaVenta(pedido.getFechaEntrega());
            gananciaTiendaRepositorio.save(gananciaTienda);

            System.out.println("Pedido marcado como entregado. Ganancias registradas.");
        }

        // Guardar los cambios en el pedido
        return pedidoRepositorio.save(pedido);
    }
}