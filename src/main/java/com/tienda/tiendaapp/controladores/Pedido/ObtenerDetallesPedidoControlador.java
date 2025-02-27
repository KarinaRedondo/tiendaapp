package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.ObtenerDetallesPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedidos")

public class ObtenerDetallesPedidoControlador {

    private ObtenerDetallesPedidoServicio obtenerDetallesPedidoServicio;

    @Autowired
    public ObtenerDetallesPedidoControlador(ObtenerDetallesPedidoServicio obtenerDetallesPedidoServicio) {
        this.obtenerDetallesPedidoServicio = obtenerDetallesPedidoServicio;
    }

    @GetMapping(value = "/obtener-detallesPedido/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> obtenerDetallesPedidoPorId(@PathVariable String id) {

        try {
            Optional<Pedido> pedido = obtenerDetallesPedidoServicio.obtenerDetallesPedidoPorId(id);

            if (pedido.isPresent()) {
                return new ResponseEntity<>(pedido.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de obtener los detalles del pedido"+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
