package com.tienda.tiendaapp.servicios.gananciaDomiciliario;

import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Service
public class GananciaSemanalServicio {

    @Autowired
    private GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public GananciaSemanalServicio(GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio,
                                   PedidoRepositorio pedidoRepositorio) {
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public void actualizarGananciaSemanal(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if ("entregado".equalsIgnoreCase(pedido.getEstado())) {
            String fechaEntrega = pedido.getFechaEntrega();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaEntregaLocalDate = LocalDate.parse(fechaEntrega, formatter);
            LocalDate fechaHoy = LocalDate.now();

            WeekFields weekFields = WeekFields.of(Locale.getDefault());

            int semanaEntrega = fechaEntregaLocalDate.get(weekFields.weekOfWeekBasedYear());
            int semanaActual = fechaHoy.get(weekFields.weekOfWeekBasedYear());
            int anioEntrega = fechaEntregaLocalDate.getYear();
            int anioActual = fechaHoy.getYear();

            if (semanaEntrega == semanaActual && anioEntrega == anioActual) {
                String idDomiciliario = pedido.getIdDomiciliario();
                double ganancia = pedido.getGananciaDomiciliario();

                GananciaDomiciliario gananciaDomiciliario = gananciaDomiciliarioRepositorio.findByIdDomiciliario(idDomiciliario);

                if (gananciaDomiciliario == null) {
                    gananciaDomiciliario = new GananciaDomiciliario();
                    gananciaDomiciliario.setIdDomiciliario(idDomiciliario);
                    gananciaDomiciliario.setGananciaSemanal(ganancia);
                } else {
                    double total = gananciaDomiciliario.getGananciaSemanal() + ganancia;
                    gananciaDomiciliario.setGananciaSemanal(total);
                }

                gananciaDomiciliarioRepositorio.save(gananciaDomiciliario);
            }
        }
    }
}
