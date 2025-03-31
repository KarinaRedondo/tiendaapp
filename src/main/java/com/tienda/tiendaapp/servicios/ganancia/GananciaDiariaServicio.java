package com.tienda.tiendaapp.servicios.ganancia;

import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GananciaDiariaServicio {

    @Autowired
    private GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public GananciaDiariaServicio(GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio,
                                  PedidoRepositorio pedidoRepositorio) {
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public void actualizarGananciaDiaria(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            String fechaEntrega = pedido.getFechaEntrega();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaEntregaLocalDate = LocalDate.parse(fechaEntrega, formatter);
            LocalDate fechaHoy = LocalDate.now();

            if (fechaEntregaLocalDate.equals(fechaHoy)) {
                String idDomiciliario = pedido.getIdDomiciliario();
                double ganancia = pedido.getGananciaDomiciliario();

                GananciaDomiciliario gananciaDomiciliario = gananciaDomiciliarioRepositorio.findByIdDomiciliario(idDomiciliario);

                if (gananciaDomiciliario == null) {
                    gananciaDomiciliario = new GananciaDomiciliario();
                    gananciaDomiciliario.setIdDomiciliario(idDomiciliario);
                    gananciaDomiciliario.setGananciaDiaria(ganancia);
                } else {
                    gananciaDomiciliario.setGananciaDiaria(gananciaDomiciliario.getGananciaDiaria() + ganancia);
                }

                gananciaDomiciliarioRepositorio.save(gananciaDomiciliario);
            }
        }
    }
}
