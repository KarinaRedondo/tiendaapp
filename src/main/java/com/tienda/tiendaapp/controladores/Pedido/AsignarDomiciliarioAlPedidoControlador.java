package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.AsignarDomiciliarioAlPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedidos")

public class AsignarDomiciliarioAlPedidoControlador {

    private final AsignarDomiciliarioAlPedidoServicio asignarDomiciliarioAlPedidoServicio;

    @Autowired
    public AsignarDomiciliarioAlPedidoControlador(AsignarDomiciliarioAlPedidoServicio asignarDomiciliarioAlPedidoServicio) {
        this.asignarDomiciliarioAlPedidoServicio =  asignarDomiciliarioAlPedidoServicio;
    }

    @PutMapping(value = "/asignar-domicliario/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> asignarDomiciliario(@PathVariable String id, @RequestBody Map<String, String> request) {

        try {
            String idDomiciliario = request.get("id");

            if (idDomiciliario == null || idDomiciliario.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "El id del domiciliario es requerido"));
            }
            Optional<Pedido> pedidoActualizado = asignarDomiciliarioAlPedidoServicio.asignarDomiciliario(id, idDomiciliario);

            return pedidoActualizado
                    .map(pedido -> ResponseEntity.ok().body(Map.of("mensaje", "Domiciliario asignado con éxito", "pedido", pedido)))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Pedido no encontrado")));
        }
        catch (Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Error al asignar domiciliario", "detalle", exception.getMessage()));
    }
    }
}
