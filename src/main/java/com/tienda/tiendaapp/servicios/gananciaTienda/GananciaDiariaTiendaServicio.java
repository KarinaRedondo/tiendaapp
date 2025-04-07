package com.tienda.tiendaapp.servicios.gananciaTienda;

import com.tienda.tiendaapp.entidades.GananciaTienda;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.repositorios.GananciaTiendaRepositorio;
import com.tienda.tiendaapp.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GananciaDiariaTiendaServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private GananciaTiendaRepositorio gananciaTiendaRepositorio;

    public void actualizarGananciaDiaria(String idPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido).orElse(null);

        if (pedido != null && "entregado".equalsIgnoreCase(pedido.getEstado())) {
            String fechaEntrega = pedido.getFechaEntrega();
            String hoy = LocalDate.now().toString();

            if (fechaEntrega.equals(hoy)) {
                String idTienda = pedido.getIdTienda();
                double ganancia = pedido.getGananciaTienda();

                GananciaTienda gananciaTienda = gananciaTiendaRepositorio.findByIdTienda(idTienda);
                if (gananciaTienda == null) {
                    gananciaTienda = new GananciaTienda();
                    gananciaTienda.setIdTienda(idTienda);
                    gananciaTienda.setGananciaDiaria(ganancia);
                    gananciaTienda.setFechaVenta(hoy);
                } else {
                    gananciaTienda.setGananciaDiaria(gananciaTienda.getGananciaDiaria() + ganancia);
                }

                gananciaTiendaRepositorio.save(gananciaTienda);
            }
        }
    }
}

