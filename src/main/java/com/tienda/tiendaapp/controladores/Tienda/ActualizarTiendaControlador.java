package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.dtos.tienda.ActualizarTiendaDto;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.servicios.Tienda.ActualizarTiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tiendas")

public class ActualizarTiendaControlador {

    private final ActualizarTiendaServicio actualizarTiendaServicio;

    @Autowired
    public ActualizarTiendaControlador(ActualizarTiendaServicio actualizarTiendaServicio) {
        this.actualizarTiendaServicio = actualizarTiendaServicio;
    }

    @PutMapping(value = "/actualizar", headers = "Accept=application/json")
    public ResponseEntity<?> actualizarTienda(@RequestBody ActualizarTiendaDto actualizarTiendaDto) {

        try {
            Tienda tiendaActualizada = actualizarTiendaServicio.actualizarTienda(actualizarTiendaDto);
            return new ResponseEntity<>(tiendaActualizada, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de actualiar la tienda: "+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
