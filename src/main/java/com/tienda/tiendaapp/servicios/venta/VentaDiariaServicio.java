package com.tienda.tiendaapp.servicios.venta;

import com.tienda.tiendaapp.entidades.HistorialVenta;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.HistorialVentaRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VentaDiariaServicio {

    @Autowired
    private HistorialVentaRepositorio historialVentaRepositorio;
    @Autowired
    private TiendaRepositorio tiendaRepositorio;
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public void actualizarVentasDiarias(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            String idTienda = pedido.getIdTienda();
            double montoTotal = pedido.getMontoTotal();
            LocalDate fechaEntrega = LocalDate.parse(pedido.getFechaEntrega());

            HistorialVenta historial = historialVentaRepositorio.findByIdTienda(idTienda);
            if (historial == null) {
                historial = new HistorialVenta();
                historial.setIdTienda(idTienda);
                historial.setFecha(fechaEntrega.toString());
                historial.setVentasDiarias(montoTotal);
            } else {
                historial.setVentasDiarias(historial.getVentasDiarias() + montoTotal);
            }

            historialVentaRepositorio.save(historial);
            actualizarTotalVentas(idTienda, montoTotal);
        }
    }

    private void actualizarTotalVentas(String idTienda, double monto) {
        Tienda tienda = tiendaRepositorio.findById(idTienda)
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));
        tienda.setTotalVentas(tienda.getTotalVentas() + monto);
        tiendaRepositorio.save(tienda);
    }
}
