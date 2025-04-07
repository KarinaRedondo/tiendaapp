package com.tienda.tiendaapp.servicios.gananciaDomiciliario;

import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GananciaMensualServicio {

    @Autowired
    private GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public GananciaMensualServicio(GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio,
                                   PedidoRepositorio pedidoRepositorio) {
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public void actualizarGananciaMensual(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            String fechaEntrega = pedido.getFechaEntrega();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaEntregaLocalDate = LocalDate.parse(fechaEntrega, formatter);
            LocalDate fechaHoy = LocalDate.now();

            int mesEntrega = fechaEntregaLocalDate.getMonthValue();
            int mesActual = fechaHoy.getMonthValue();
            int anioEntrega = fechaEntregaLocalDate.getYear();
            int anioActual = fechaHoy.getYear();

            if (mesEntrega == mesActual && anioEntrega == anioActual) {
                String idDomiciliario = pedido.getIdDomiciliario();
                double ganancia = pedido.getGananciaDomiciliario();

                GananciaDomiciliario gananciaDomiciliario = gananciaDomiciliarioRepositorio.findByIdDomiciliario(idDomiciliario);

                if (gananciaDomiciliario == null) {
                    gananciaDomiciliario = new GananciaDomiciliario();
                    gananciaDomiciliario.setIdDomiciliario(idDomiciliario);
                    gananciaDomiciliario.setGananciaMensual(ganancia);
                } else {
                    double total = gananciaDomiciliario.getGananciaMensual() + ganancia;
                    gananciaDomiciliario.setGananciaMensual(total);
                }

                gananciaDomiciliarioRepositorio.save(gananciaDomiciliario);
            }
        }
    }
}

