package com.tienda.tiendaapp.servicios.ganancia;

import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GananciaAnualServicio {

    @Autowired
    private GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;
    private PedidoRepositorio pedidoRepositorio;

    public GananciaAnualServicio(GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio,
                                 PedidoRepositorio pedidoRepositorio) {
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public void actualizarGananciaAnual(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            LocalDate fechaEntrega = LocalDate.parse(pedido.getFechaEntrega());
            LocalDate fechaHoy = LocalDate.now();

            if (fechaEntrega.getYear() == fechaHoy.getYear()) {
                String idDomiciliario = pedido.getIdDomiciliario();
                double ganancia = pedido.getGananciaDomiciliario();

                GananciaDomiciliario gananciaDomiciliario = gananciaDomiciliarioRepositorio.findByIdDomiciliario(idDomiciliario);

                if (gananciaDomiciliario == null) {
                    gananciaDomiciliario = new GananciaDomiciliario();
                    gananciaDomiciliario.setIdDomiciliario(idDomiciliario);
                    gananciaDomiciliario.setGananciaAnual(ganancia);
                } else {
                    gananciaDomiciliario.setGananciaAnual(gananciaDomiciliario.getGananciaAnual() + ganancia);
                }

                gananciaDomiciliarioRepositorio.save(gananciaDomiciliario);
            }
        }
    }
}
