package com.tienda.tiendaapp.controladores.Auth.Pedido;

import com.tienda.tiendaapp.dtos.ActualizarPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.ActualizarPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class ActualizarPedidoControlador {
    private final ActualizarPedidoService actualizarPedidoService;

    @Autowired
    public ActualizarPedidoControlador(ActualizarPedidoService actualizarPedidoService){
        this.actualizarPedidoService = actualizarPedidoService;
    }
    @PutMapping(value = "/pedidos", headers = "Accept=application/json")
    public ResponseEntity<?> actualizarPedido(@RequestBody ActualizarPedidoDto actualizarPedidoDto){
        try {
            Pedido pedidoActualizado = actualizarPedidoService.actualizarPedido(actualizarPedidoDto);
            return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
        } catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de actualizar el pedido" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
