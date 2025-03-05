package com.tienda.tiendaapp.controladores.Pedido;

import com.tienda.tiendaapp.entidades.Pedido;
import com.tienda.tiendaapp.servicios.Pedido.ListarPedidosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1")

public class ListarPedidosControlador {

    private final ListarPedidosServicio listarPedidosServicio;

    @Autowired
    public ListarPedidosControlador(ListarPedidosServicio listarPedidosServicio){
        this.listarPedidosServicio = listarPedidosServicio;
    }

    @GetMapping(value = "/pedidos/listar", headers = "Accept=application/json")
    public ResponseEntity<?> listarPedidosControlador(){

        try {
            List<Pedido> listaPedidosRetornada = listarPedidosServicio.ListarPedidos();
            return new ResponseEntity<>(listaPedidosRetornada, HttpStatus.OK);
        }
        catch (Exception exception){
            String mensajeDeError = "Hubo un erroral tratar de obtener los pedidos" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
