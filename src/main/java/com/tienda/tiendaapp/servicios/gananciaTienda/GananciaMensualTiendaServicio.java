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
public class GananciaMensualTiendaServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private GananciaTiendaRepositorio gananciaTiendaRepositorio;

    public void actualizarGananciaMensual(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido).orElse(null);

        if (pedido != null && "entregado".equalsIgnoreCase(pedido.getEstado())) {
            LocalDate fechaEntrega = LocalDate.parse(pedido.getFechaEntrega());
            LocalDate inicioMes = fechaEntrega.with(TemporalAdjusters.firstDayOfMonth());
            LocalDate finMes = fechaEntrega.with(TemporalAdjusters.lastDayOfMonth());
            LocalDate hoy = LocalDate.now();

            if (!hoy.isBefore(inicioMes) && !hoy.isAfter(finMes)) {
                String idTienda = pedido.getIdTienda();
                double ganancia = pedido.getGananciaTienda();

                GananciaTienda gananciaTienda = gananciaTiendaRepositorio.findByIdTienda(idTienda);
                if (gananciaTienda == null) {
                    gananciaTienda = new GananciaTienda();
                    gananciaTienda.setIdTienda(idTienda);
                    gananciaTienda.setGananciaMensual(ganancia);
                    gananciaTienda.setFechaVenta(hoy.toString());
                } else {
                    gananciaTienda.setGananciaMensual(gananciaTienda.getGananciaMensual() + ganancia);
                }

                gananciaTiendaRepositorio.save(gananciaTienda);
            }
        }
    }
}
