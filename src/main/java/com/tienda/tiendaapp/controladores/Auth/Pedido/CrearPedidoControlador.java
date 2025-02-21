package com.tienda.tiendaapp.controladores.Auth.Pedido;

import com.tienda.tiendaapp.dtos.CrearPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.CrearPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class CrearPedidoControlador {
    private final CrearPedidoService crearPedidoService;

    @Autowired
    public CrearPedidoControlador(CrearPedidoService crearPedidoService){
        this.crearPedidoService = crearPedidoService;
    }
    @PostMapping(value = "/pedidos", headers = "Accept=application/json")
    public ResponseEntity<?> crearPedido(@RequestBody CrearPedidoDto crearPedidoDto){
        try {
            Pedido pedidoCreado = crearPedidoService.crearPedido(crearPedidoDto);
            return new ResponseEntity<>(pedidoCreado, HttpStatus.CREATED);
        } catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de crear el pedido" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
