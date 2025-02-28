package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.FiltrarPedidosPorEstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")

public class FiltrarPedidosPorEstadoControlador {

    private final FiltrarPedidosPorEstadoServicio filtrarPedidosPorEstadoServicio;

    @Autowired
    public FiltrarPedidosPorEstadoControlador(FiltrarPedidosPorEstadoServicio filtrarPedidosPorEstadoServicio) {
        this.filtrarPedidosPorEstadoServicio = filtrarPedidosPorEstadoServicio;
    }

    @GetMapping("/filtrar/estado/{estado}")
    public ResponseEntity<List<Pedido>> obtenerPedidosPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(filtrarPedidosPorEstadoServicio.obtenerPedidosPorEstado(estado));
    }

    @GetMapping("/filtrar/cliente/{idCliente}/estado/{estado}")
    public ResponseEntity<List<Pedido>> obtenerPedidosClientePorEstado(@PathVariable String idCliente, @PathVariable String estado) {
       return ResponseEntity.ok(filtrarPedidosPorEstadoServicio.obtenerPedidosClientePorEstado(idCliente, estado));
    }

    @GetMapping("/filtrar/tienda/{idTienda}/estado/{estado}")
    public ResponseEntity<List<Pedido>> obtenerPedidosTiendaPorEstado(@PathVariable String idTienda, @PathVariable String estado) {
        return ResponseEntity.ok(filtrarPedidosPorEstadoServicio.obtenerPedidosTiendaPorEstado(idTienda, estado));
    }
}
