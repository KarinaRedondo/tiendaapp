package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.dtos.pedido.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ActualizarPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;
    private final TiendaRepositorio tiendaRepositorio;
    private final GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;

    @Autowired
    public ActualizarPedidoServicio(PedidoRepositorio pedidoRepositorio, TiendaRepositorio tiendaRepositorio, GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.tiendaRepositorio = tiendaRepositorio;
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
    }

    public Pedido actualizarPedido(ActualizarPedidoDto actualizarPedidoDto) {
        // Buscar el pedido por su ID
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(actualizarPedidoDto.getId());

        if (pedidoOptional.isPresent()) {
            Pedido pedidoEncontrado = pedidoOptional.get();

            // Actualizar los campos del pedido con los valores del DTO
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

            // Si el pedido está en estado "Entregado", actualizar la tienda y la ganancia del domiciliario
            if ("Entregado".equals(pedidoEncontrado.getEstado())) {
                actualizarTienda(pedidoEncontrado);
                actualizarGananciaDomiciliario(pedidoEncontrado);
            }

            // Guardar y devolver el pedido actualizado
            return pedidoRepositorio.save(pedidoEncontrado);
        } else {
            // Si no se encuentra el pedido, devolver null
            return null;
        }
    }

    private void actualizarTienda(Pedido pedido) {
        // Buscar la tienda por su ID
        Optional<Tienda> tiendaOptional = tiendaRepositorio.findById(pedido.getIdTienda());

        if (tiendaOptional.isPresent()) {
            Tienda tienda = tiendaOptional.get();
            // Sumar el monto total del pedido al total de ventas de la tienda
            tienda.setTotalVentas(tienda.getTotalVentas() + pedido.getMontoTotal());
            tiendaRepositorio.save(tienda);
        } else {
            // Si no existe la tienda, lanzar una excepción o manejarlo según tu lógica de negocio
            throw new RuntimeException("Tienda no encontrada con ID: " + pedido.getIdTienda());
        }
    }

    private void actualizarGananciaDomiciliario(Pedido pedido) {
        // Buscar la ganancia del domiciliario por su ID
        Optional<GananciaDomiciliario> gananciaOptional = gananciaDomiciliarioRepositorio.findById(pedido.getIdDomiciliario());

        if (gananciaOptional.isPresent()) {
            GananciaDomiciliario ganancia = gananciaOptional.get();
            // Sumar el precio del domicilio a la ganancia existente
            ganancia.setGanancia(ganancia.getGanancia() + pedido.getPrecioDomicilio());
            gananciaDomiciliarioRepositorio.save(ganancia);
        } else {
            // Si no existe, crear una nueva ganancia para el domiciliario
            GananciaDomiciliario nuevaGanancia = new GananciaDomiciliario();
            nuevaGanancia.setIdPedido(pedido.getId());
            nuevaGanancia.setGanancia(pedido.getPrecioDomicilio());
            nuevaGanancia.setIdDomiciliario(pedido.getIdDomiciliario());
            nuevaGanancia.setFechaEntrega(pedido.getFechaCreacion());
            gananciaDomiciliarioRepositorio.save(nuevaGanancia);
        }
    }
}