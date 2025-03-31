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
import java.time.temporal.WeekFields;
import java.util.Locale;

@Service
public class VentaSemanalServicio {

    @Autowired
    private HistorialVentaRepositorio historialVentaRepositorio;
    private TiendaRepositorio tiendaRepositorio;
    private PedidoRepositorio pedidoRepositorio;

    public VentaSemanalServicio(HistorialVentaRepositorio historialVentaRepositorio,
                                TiendaRepositorio tiendaRepositorio,
                                PedidoRepositorio pedidoRepositorio) {
        this.historialVentaRepositorio = historialVentaRepositorio;
        this.tiendaRepositorio = tiendaRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    // Método para actualizar las ventas semanales
    public void actualizarVentasSemanales(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        // Verificamos si el pedido fue entregado
        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            // Obtenemos la fecha de entrega del pedido
            String fechaEntrega = pedido.getFechaEntrega();

            // Convertimos la fecha de entrega de String a LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaEntregaLocalDate = LocalDate.parse(fechaEntrega, formatter);

            // Obtenemos el primer día de la semana de la fecha de entrega
            LocalDate inicioSemana = fechaEntregaLocalDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);

            // Obtenemos la fecha actual
            LocalDate fechaHoy = LocalDate.now();
            LocalDate inicioSemanaActual = fechaHoy.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);

            // Comparamos si la venta ocurrió dentro de la misma semana
            if (inicioSemana.equals(inicioSemanaActual)) {
                String idTienda = pedido.getIdTienda();
                double montoTotal = pedido.getMontoTotal();

                Tienda tienda = tiendaRepositorio.findById(idTienda)
                        .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));

                HistorialVenta historialVenta = historialVentaRepositorio.findByIdTienda(idTienda);

                if (historialVenta == null) {
                    historialVenta = new HistorialVenta();
                    historialVenta.setIdTienda(idTienda);
                    historialVenta.setVentasSemanales(montoTotal);
                } else {
                    historialVenta.setVentasSemanales(historialVenta.getVentasSemanales() + montoTotal);
                }

                historialVentaRepositorio.save(historialVenta);
                tienda.setTotalVentas(tienda.getTotalVentas() + montoTotal);
                tiendaRepositorio.save(tienda);
            }
        }
    }
}
