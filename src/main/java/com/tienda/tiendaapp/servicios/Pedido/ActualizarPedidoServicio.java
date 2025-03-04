package com.tienda.tiendaapp.servicios.Pedido;

import com.tienda.tiendaapp.dtos.pedido.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.entidades.HistorialVenta;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import com.tienda.tiendaapp.repositorios.HistorialVentaRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ActualizarPedidoServicio {

    private final PedidoRepositorio pedidoRepositorio;
    private final TiendaRepositorio tiendaRepositorio;
    private final GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;
    private final HistorialVentaRepositorio historialVentaRepositorio;

    @Autowired
    public ActualizarPedidoServicio(
            PedidoRepositorio pedidoRepositorio,
            TiendaRepositorio tiendaRepositorio,
            GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio,
            HistorialVentaRepositorio historialVentaRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.tiendaRepositorio = tiendaRepositorio;
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
        this.historialVentaRepositorio = historialVentaRepositorio;
    }

    public Pedido actualizarPedido(ActualizarPedidoDto actualizarPedidoDto) {
        Pedido pedidoEncontrado = pedidoRepositorio.findById(actualizarPedidoDto.getId())
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + actualizarPedidoDto.getId()));

        // Actualizar datos del pedido
        pedidoEncontrado.setIdCliente(actualizarPedidoDto.getIdCliente());
        pedidoEncontrado.setIdTienda(actualizarPedidoDto.getIdTienda());
        pedidoEncontrado.setDescripcionPedido(actualizarPedidoDto.getDescripcionPedido());
        pedidoEncontrado.setMontoTotal(Optional.ofNullable(actualizarPedidoDto.getMontoTotal()).orElse(0.0));
        pedidoEncontrado.setPrecioDomicilio(Optional.ofNullable(actualizarPedidoDto.getPrecioDomicilio()).orElse(0.0));
        pedidoEncontrado.setEstado(actualizarPedidoDto.getEstado());
        pedidoEncontrado.setIdDomiciliario(actualizarPedidoDto.getIdDomiciliario());
        pedidoEncontrado.setGananciaDomiciliario(Optional.ofNullable(actualizarPedidoDto.getGananciaDomiciliario()).orElse(0.0));
        pedidoEncontrado.setComentariosTendero(actualizarPedidoDto.getComentariosTendero());
        pedidoEncontrado.setFechaCreacion(actualizarPedidoDto.getFechaCreacion());
        pedidoEncontrado.setFechaExpiracion(actualizarPedidoDto.getFechaExpiracion());

        // Guardar pedido antes de actualizar otros valores
        pedidoRepositorio.save(pedidoEncontrado);

        // Si el pedido está en estado "Entregado", actualizar tienda, historial y domiciliario
        if ("Entregado".equals(pedidoEncontrado.getEstado())) {
            actualizarTienda(pedidoEncontrado);
            actualizarHistorialVenta(pedidoEncontrado);
            actualizarGananciaDomiciliario(pedidoEncontrado);
        }

        return pedidoEncontrado;
    }

    private void actualizarTienda(Pedido pedido) {
        Tienda tienda = tiendaRepositorio.findById(pedido.getIdTienda())
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada con ID: " + pedido.getIdTienda()));

        // Acumular el monto total de la tienda
        double totalVentasActual = Optional.ofNullable(tienda.getTotalVentas()).orElse(0.0);
        tienda.setTotalVentas(totalVentasActual + pedido.getMontoTotal());

        tiendaRepositorio.save(tienda);
    }

    private void actualizarHistorialVenta(Pedido pedido) {
        String idHistorial = pedido.getIdTienda() + "_" + pedido.getFechaCreacion();
        HistorialVenta historial = historialVentaRepositorio.findById(idHistorial)
                .orElseGet(() -> {
                    HistorialVenta nuevoHistorial = new HistorialVenta();
                    nuevoHistorial.setId(idHistorial);
                    nuevoHistorial.setIdTienda(pedido.getIdTienda());
                    nuevoHistorial.setFecha(pedido.getFechaCreacion());
                    nuevoHistorial.setVentasDiarias(0.0);
                    nuevoHistorial.setVentasSemanales(0.0);
                    nuevoHistorial.setVentasMensuales(0.0);
                    return nuevoHistorial;
                });

        // Acumular ventas en todas las categorías
        historial.setVentasDiarias(Optional.ofNullable(historial.getVentasDiarias()).orElse(0.0) + pedido.getMontoTotal());
        historial.setVentasSemanales(Optional.ofNullable(historial.getVentasSemanales()).orElse(0.0) + pedido.getMontoTotal());
        historial.setVentasMensuales(Optional.ofNullable(historial.getVentasMensuales()).orElse(0.0) + pedido.getMontoTotal());

        historialVentaRepositorio.save(historial);
    }

    private void actualizarGananciaDomiciliario(Pedido pedido) {
        if (pedido.getIdDomiciliario() == null) {
            return; // No hay domiciliario asignado, no se actualiza nada
        }

        String idGanancia = pedido.getIdDomiciliario() + "_" + pedido.getFechaCreacion();
        GananciaDomiciliario ganancia = gananciaDomiciliarioRepositorio.findById(idGanancia)
                .orElseGet(() -> {
                    GananciaDomiciliario nuevaGanancia = new GananciaDomiciliario();
                    nuevaGanancia.setId(idGanancia);
                    nuevaGanancia.setIdPedido(pedido.getId());
                    nuevaGanancia.setIdDomiciliario(pedido.getIdDomiciliario());
                    nuevaGanancia.setFechaEntrega(pedido.getFechaCreacion());
                    nuevaGanancia.setGanancia(0.0);
                    return nuevaGanancia;
                });

        // Acumular la ganancia del domiciliario
        ganancia.setGanancia(Optional.ofNullable(ganancia.getGanancia()).orElse(0.0) + pedido.getPrecioDomicilio());

        gananciaDomiciliarioRepositorio.save(ganancia);
    }
}


