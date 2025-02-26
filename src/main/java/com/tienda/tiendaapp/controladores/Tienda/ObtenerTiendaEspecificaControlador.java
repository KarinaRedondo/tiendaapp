package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.controladores.Usuario.ObtenerUsuarioAutenticadoControlador;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.servicios.Tienda.ObtenerTiendaEspecificaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tiendas")

public class ObtenerTiendaEspecificaControlador {

    private ObtenerTiendaEspecificaServicio obtenerTiendaEspecificaServicio;

    @Autowired
    public ObtenerTiendaEspecificaControlador(ObtenerTiendaEspecificaServicio obtenerTiendaEspecificaServicio) {
        this.obtenerTiendaEspecificaServicio = obtenerTiendaEspecificaServicio;
    }

    @GetMapping(value = "/obtener/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> obtenerTiendaPorId(@PathVariable String id) {

        try {
            Optional<Tienda> tienda = obtenerTiendaEspecificaServicio.obtenerTiendaPoId(id);

            if (tienda.isPresent()) {
                return new ResponseEntity<>(tienda.get(), HttpStatus.OK);
            }
            else  {
                return new ResponseEntity<>("Tienda no encontrada", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al obtener la tienda especifica" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
