package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.servicios.Tienda.ListarTiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiendas")

public class ListarTiendaControlador {

    private final ListarTiendaServicio listarTiendaServicio;

    @Autowired
    public ListarTiendaControlador(ListarTiendaServicio listarTiendaServicio) {
        this.listarTiendaServicio = listarTiendaServicio;
    }

    @GetMapping(value = "/listar", headers = "Accept=application/json")
    public ResponseEntity<?> listarTiendaControlador() {

        try {
            List<Tienda> listaTiendasRetornada = listarTiendaServicio.listarTiendas();
            return new ResponseEntity<>(listaTiendasRetornada, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de obtener las tiendas: "+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
