package com.tienda.tiendaapp.controladores.Calificacion;

import com.tienda.tiendaapp.servicios.Calificacion.ObtenerCalificacionesTiendaDomiciliarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calificaciones")

public class ObtenerCalificacionesTiendaDomiciliarioControlador {

    private final ObtenerCalificacionesTiendaDomiciliarioServicio obtenerCalificacionesTiendaDomiciliarioServicio;

    @Autowired
    public ObtenerCalificacionesTiendaDomiciliarioControlador(ObtenerCalificacionesTiendaDomiciliarioServicio obtenerCalificacionesTiendaDomiciliarioServicio) {
        this.obtenerCalificacionesTiendaDomiciliarioServicio = obtenerCalificacionesTiendaDomiciliarioServicio;
    }

    @GetMapping("/obtener/tienda/{idTienda}")
    public ResponseEntity<?> obtenerCalificacionTienda(@PathVariable String idTienda) {
        try {
            return new ResponseEntity<>(obtenerCalificacionesTiendaDomiciliarioServicio.obtenerCalificacionTienda(idTienda), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener calificaciones", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/obtener/domiciliario/{idDomiciliario}")
    public ResponseEntity<?> obtenerCalificacionDomiciliario(@PathVariable String idDomiciliario) {
        try {
            return new ResponseEntity<>(obtenerCalificacionesTiendaDomiciliarioServicio.obtenerCalificacionDomiciliario(idDomiciliario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener calificaciones", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
