package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.dtos.pedido.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.ActualizarPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pedidos")
public class ActualizarPedidoControlador {

    private final ActualizarPedidoServicio actualizarPedidoServicio;

    @Autowired
    public ActualizarPedidoControlador(ActualizarPedidoServicio actualizarPedidoServicio) {
        this.actualizarPedidoServicio = actualizarPedidoServicio;
    }

    @PutMapping(value = "/actualizar", consumes = "application/json")
    public ResponseEntity<?> actualizarPedido(@RequestBody ActualizarPedidoDto actualizarPedidoDto) {
        try {
            if (actualizarPedidoDto == null || actualizarPedidoDto.getId() == null) {
                return new ResponseEntity<>("El ID del pedido es obligatorio", HttpStatus.BAD_REQUEST);
            }

            Pedido pedidoActualizado = actualizarPedidoServicio.actualizarPedido(actualizarPedidoDto);
            return ResponseEntity.ok(pedidoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Hubo un error al tratar de actualizar el pedido: " + exception.getMessage());
        }
    }
}

