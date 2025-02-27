package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.servicios.Pedido.EliminarPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidos")

public class EliminarPedidoControlador {

    private final EliminarPedidoServicio eliminarPedidoServicio;

    @Autowired
    public EliminarPedidoControlador(EliminarPedidoServicio eliminarPedidoServicio){
        this.eliminarPedidoServicio = eliminarPedidoServicio;
    }
    @DeleteMapping(value = "/eliminar/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> eliminarPedido(@PathVariable("id") String id) {

        try {
            boolean respuesta = eliminarPedidoServicio.elimiarPedido(id);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }
        catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de eliminar el pedido" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
