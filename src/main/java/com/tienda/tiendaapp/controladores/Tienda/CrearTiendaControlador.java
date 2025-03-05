package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.dtos.tienda.CrearTiendaDto;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.servicios.Tienda.CrearTiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class CrearTiendaControlador {

    private final CrearTiendaServicio crearTiendaServicio;

    @Autowired
    public  CrearTiendaControlador(CrearTiendaServicio crearTiendaServicio) {
        this.crearTiendaServicio = crearTiendaServicio;
    }

    @PostMapping(value = "/tiendas/crear", headers = "Accept=application/json")
    public ResponseEntity<?> crearTienda(@RequestBody CrearTiendaDto crearTiendaDto) {

        try {
            Tienda tiendaCreada = crearTiendaServicio.crearTienda(crearTiendaDto);
            return new ResponseEntity<>(tiendaCreada, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear la tienda: "+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
