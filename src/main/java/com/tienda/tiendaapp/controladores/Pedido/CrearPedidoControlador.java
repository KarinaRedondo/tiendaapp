package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.dtos.pedido.CrearPedidoDto;
import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.CrearPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidos")

public class CrearPedidoControlador {

    private final CrearPedidoServicio crearPedidoServicio;

    @Autowired
    public CrearPedidoControlador(CrearPedidoServicio crearPedidoServicio){
        this.crearPedidoServicio = crearPedidoServicio;
    }

    @PostMapping(value = "/crear", headers = "Accept=application/json")
    public ResponseEntity<?> crearPedido(@RequestBody CrearPedidoDto crearPedidoDto){

        try {
            Pedido pedidoCreado = crearPedidoServicio.crearPedido(crearPedidoDto);
            return new ResponseEntity<>(pedidoCreado, HttpStatus.CREATED);
        }
        catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de crear el pedido" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
