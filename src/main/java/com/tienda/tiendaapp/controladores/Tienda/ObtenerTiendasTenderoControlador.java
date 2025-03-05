package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.servicios.Tienda.ObtenerTiendasTenderoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ObtenerTiendasTenderoControlador {

    private final ObtenerTiendasTenderoServicio obtenerTiendasTenderoServicio;

    @Autowired
    public ObtenerTiendasTenderoControlador(ObtenerTiendasTenderoServicio obtenerTiendasTenderoServicio) {
        this.obtenerTiendasTenderoServicio = obtenerTiendasTenderoServicio;
    }

    @GetMapping(value = "/tiendas/obtener-tiendasTendero/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> obtenerTiendasTendero(@PathVariable String id) {

       try {
           List<Tienda> tiendas = obtenerTiendasTenderoServicio.obtenerTiendasPorIdTendero(id);

           if (tiendas.isEmpty()) {
               return new ResponseEntity<>("No se encontraron tiendas para este usuario", HttpStatus.NOT_FOUND);
           }
           return new ResponseEntity<>(tiendas, HttpStatus.OK);
       }
       catch (Exception exception) {
           String mensajeDeError = "Hubo un error al obtener la tiendas del tendero" + exception.getMessage();
           return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
