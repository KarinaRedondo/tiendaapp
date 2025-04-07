package com.tienda.tiendaapp.servicios.gananciaTienda;

import com.tienda.tiendaapp.entidades.GananciaTienda;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaTiendaRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class GananciaSemanalTiendaServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private GananciaTiendaRepositorio gananciaTiendaRepositorio;

    public void actualizarGananciaSemanal(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido).orElse(null);

        if (pedido != null && "entregado".equalsIgnoreCase(pedido.getEstado())) {
            LocalDate fechaEntrega = LocalDate.parse(pedido.getFechaEntrega());
            LocalDate inicioSemana = fechaEntrega.with(DayOfWeek.MONDAY);
            LocalDate finSemana = inicioSemana.plusDays(6);
            LocalDate hoy = LocalDate.now();

            if (!hoy.isBefore(inicioSemana) && !hoy.isAfter(finSemana)) {
                String idTienda = pedido.getIdTienda();
                double ganancia = pedido.getGananciaTienda();

                GananciaTienda gananciaTienda = gananciaTiendaRepositorio.findByIdTienda(idTienda);
                if (gananciaTienda == null) {
                    gananciaTienda = new GananciaTienda();
                    gananciaTienda.setIdTienda(idTienda);
                    gananciaTienda.setGananciaSemanal(ganancia);
                    gananciaTienda.setFechaVenta(hoy.toString());
                } else {
                    gananciaTienda.setGananciaSemanal(gananciaTienda.getGananciaSemanal() + ganancia);
                }

                gananciaTiendaRepositorio.save(gananciaTienda);
            }
        }
    }
}

