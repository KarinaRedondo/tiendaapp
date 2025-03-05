package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.CambiarEstadoPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class CambiarEstadoPedidoControlador {

    private final CambiarEstadoPedidoServicio cambiarEstadoPedidoServicio;

    @Autowired
    public CambiarEstadoPedidoControlador(CambiarEstadoPedidoServicio cambiarEstadoPedidoServicio) {
        this.cambiarEstadoPedidoServicio = cambiarEstadoPedidoServicio;
    }

    @PutMapping(value = "/pedidos/cambiar-estado/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> cambiarEstado(@PathVariable String id, @RequestBody Map<String, String> request) {
        String nuevoEstado = request.get("estado");

        if (nuevoEstado == null || nuevoEstado.isEmpty()) {
            return new ResponseEntity<>("El nuevo estado es requerido", HttpStatus.BAD_REQUEST);
        }
        Optional<Pedido> pedidoActualizado = cambiarEstadoPedidoServicio.actualizarEstado(id, nuevoEstado);

        if (pedidoActualizado.isPresent()) {
            return ResponseEntity.ok(pedidoActualizado.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
        }
    }
}
