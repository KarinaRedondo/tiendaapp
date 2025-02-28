package com.tienda.tiendaapp.controladores.Calificacion;

import com.tienda.tiendaapp.dtos.calificacion.CrearCalificacionDto;
import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.servicios.Calificacion.CrearCalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calificaciones")

public class CrearCalificacionControlador {

    private final CrearCalificacionServicio crearCalificacionServicio;

    @Autowired
    public CrearCalificacionControlador(CrearCalificacionServicio crearCalificacionServicio) {
        this.crearCalificacionServicio = crearCalificacionServicio;
    }

    @PostMapping(value = "/crear", headers = "Accept=application/json")
    public ResponseEntity<?> crearCalificacion(@RequestBody CrearCalificacionDto crearCalificacionDto) {

        try {
            Calificacion califiacionCreada = crearCalificacionServicio.crearCalificacion(crearCalificacionDto);
            return new ResponseEntity<>(califiacionCreada, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear la calificacion: "+exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
