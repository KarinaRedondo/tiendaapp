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
import java.time.format.DateTimeFormatter;

@Service
public class VentaMensualServicio {

    @Autowired
    private HistorialVentaRepositorio historialVentaRepositorio;
    private TiendaRepositorio tiendaRepositorio;
    private PedidoRepositorio pedidoRepositorio;

    public VentaMensualServicio(HistorialVentaRepositorio historialVentaRepositorio,
                                TiendaRepositorio tiendaRepositorio,
                                PedidoRepositorio pedidoRepositorio) {
        this.historialVentaRepositorio = historialVentaRepositorio;
        this.tiendaRepositorio = tiendaRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    // Método para actualizar las ventas mensuales
    public void actualizarVentasMensuales(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            String fechaEntrega = pedido.getFechaEntrega();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaEntregaLocalDate = LocalDate.parse(fechaEntrega, formatter);

            // Obtenemos el año y el mes de la fecha de entrega
            int añoEntrega = fechaEntregaLocalDate.getYear();
            int mesEntrega = fechaEntregaLocalDate.getMonthValue();

            // Obtenemos el año y el mes actual
            LocalDate fechaHoy = LocalDate.now();
            int añoActual = fechaHoy.getYear();
            int mesActual = fechaHoy.getMonthValue();

            // Comparamos si la venta ocurrió dentro del mismo mes y año
            if (añoEntrega == añoActual && mesEntrega == mesActual) {
                String idTienda = pedido.getIdTienda();
                double montoTotal = pedido.getMontoTotal();

                Tienda tienda = tiendaRepositorio.findById(idTienda)
                        .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));

                HistorialVenta historialVenta = historialVentaRepositorio.findByIdTienda(idTienda);

                if (historialVenta == null) {
                    historialVenta = new HistorialVenta();
                    historialVenta.setIdTienda(idTienda);
                    historialVenta.setVentasMensuales(montoTotal);
                } else {
                    historialVenta.setVentasMensuales(historialVenta.getVentasMensuales() + montoTotal);
                }

                historialVentaRepositorio.save(historialVenta);
                tienda.setTotalVentas(tienda.getTotalVentas() + montoTotal);
                tiendaRepositorio.save(tienda);
            }
        }
    }
}

