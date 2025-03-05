package com.tienda.tiendaapp.controladores.Usuario;

import com.tienda.tiendaapp.servicios.Usuario.EliminarUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class EliminarUsuarioControlador {

    private final EliminarUsuarioServicio eliminarUsuarioServicio;

    @Autowired
    public EliminarUsuarioControlador(EliminarUsuarioServicio eliminarUsuarioServicio) {
        this.eliminarUsuarioServicio = eliminarUsuarioServicio;
    }

    @DeleteMapping(value = "/usuarios/eliminar/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") String id) {

        try {
            boolean respuesta = eliminarUsuarioServicio.eliminarUsuario(id);
            return new ResponseEntity<>(respuesta , HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de eliminar el usuario" +exception.getMessage();
            return  new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
