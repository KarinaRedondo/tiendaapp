package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.servicios.Tienda.EliminarTiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tiendas")

public class EliminarTiendaControlador {

    private final EliminarTiendaServicio eliminarTiendaServicio;

    @Autowired
    public EliminarTiendaControlador(EliminarTiendaServicio eliminarTiendaServicio) {
        this.eliminarTiendaServicio = eliminarTiendaServicio;
    }

    @DeleteMapping(value = "/eliminar/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> eliminarTienda(@PathVariable("id") String id) {

        try {
            boolean respuesta = eliminarTiendaServicio.eliminarTienda(id);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de eliminar la tienda: "+ exception.getMessage();
            return  new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
