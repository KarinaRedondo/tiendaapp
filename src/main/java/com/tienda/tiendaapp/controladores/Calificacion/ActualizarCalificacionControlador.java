package com.tienda.tiendaapp.controladores.Calificacion;

import com.tienda.tiendaapp.dtos.calificacion.ActualizarCalificacionDto;
import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.servicios.Calificacion.ActualizarCalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class ActualizarCalificacionControlador {

    private final ActualizarCalificacionServicio actualizarCalificacionServicio;

    @Autowired
    public ActualizarCalificacionControlador(ActualizarCalificacionServicio actualizarCalificacionServicio) {
        this.actualizarCalificacionServicio = actualizarCalificacionServicio;
    }

    @PutMapping(value = "/calificaciones/actualizar", headers = "Accept=application/json")
    public ResponseEntity<?> actualizarCalificacion(@RequestBody ActualizarCalificacionDto actualizarCalificacionDto) {

        try {
            Calificacion calificacionActualizada = actualizarCalificacionServicio.actualizarCalificacion(actualizarCalificacionDto);
            return new ResponseEntity<>(calificacionActualizada, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de actualizar la calificación: "+exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
