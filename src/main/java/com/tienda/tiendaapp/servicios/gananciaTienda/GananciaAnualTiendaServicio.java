package com.tienda.tiendaapp.servicios.gananciaTienda;

import com.tienda.tiendaapp.entidades.GananciaTienda;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaTiendaRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Service
public class GananciaAnualTiendaServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private GananciaTiendaRepositorio gananciaTiendaRepositorio;

    public void actualizarGananciaAnual(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido).orElse(null);

        if (pedido != null && "entregado".equalsIgnoreCase(pedido.getEstado())) {
            LocalDate fechaEntrega = LocalDate.parse(pedido.getFechaEntrega());
            LocalDate inicioAnio = fechaEntrega.with(TemporalAdjusters.firstDayOfYear());
            LocalDate finAnio = fechaEntrega.with(TemporalAdjusters.lastDayOfYear());
            LocalDate hoy = LocalDate.now();

            if (!hoy.isBefore(inicioAnio) && !hoy.isAfter(finAnio)) {
                String idTienda = pedido.getIdTienda();
                double ganancia = pedido.getGananciaTienda();

                GananciaTienda gananciaTienda = gananciaTiendaRepositorio.findByIdTienda(idTienda);
                if (gananciaTienda == null) {
                    gananciaTienda = new GananciaTienda();
                    gananciaTienda.setIdTienda(idTienda);
                    gananciaTienda.setGananciaAnual(ganancia);
                    gananciaTienda.setFechaVenta(hoy.toString());
                } else {
                    gananciaTienda.setGananciaAnual(gananciaTienda.getGananciaAnual() + ganancia);
                }

                gananciaTiendaRepositorio.save(gananciaTienda);
            }
        }
    }
}

