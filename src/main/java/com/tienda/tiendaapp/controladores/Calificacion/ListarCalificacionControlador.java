package com.tienda.tiendaapp.controladores.Calificacion;

import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.servicios.Calificacion.ListarCalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ListarCalificacionControlador {

    private final ListarCalificacionServicio listarCalificacionServicio;

    @Autowired
    public ListarCalificacionControlador(ListarCalificacionServicio listarCalificacionServicio) {
        this.listarCalificacionServicio = listarCalificacionServicio;
    }

    @GetMapping(value = "/calificaciones/listar", headers = "Accept=application/json")
    public ResponseEntity<?> listarCalificacionesControlador() {

        try {
            List<Calificacion> listaCalificacionesRetornada = listarCalificacionServicio.listarCalificaciones();
            return new ResponseEntity<>(listaCalificacionesRetornada, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajedeError = "Hubo un error al tratar de obtener las calificaciones: "+ exception.getMessage();
            return new ResponseEntity<>(mensajedeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
