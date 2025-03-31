package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.dtos.pedido.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.ActualizarPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ActualizarPedidoControlador {

    private final ActualizarPedidoServicio actualizarPedidoServicio;

    @Autowired
    public ActualizarPedidoControlador(ActualizarPedidoServicio actualizarPedidoServicio) {
        this.actualizarPedidoServicio = actualizarPedidoServicio;
    }

    @PutMapping(value = "/pedidos/actualizar", consumes = "application/json")
    public ResponseEntity<?> actualizarPedido(@RequestBody ActualizarPedidoDto actualizarPedidoDto) {

        try {
            Pedido pedidoActualizado = actualizarPedidoServicio.actualizarPedido(actualizarPedidoDto);
            return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de actualizar el pedido: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

