package com.tienda.tiendaapp.controladores.Usuario;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.servicios.Usuario.ObtenerUsuarioAutenticadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")

public class ObtenerUsuarioAutenticadoControlador {

    private ObtenerUsuarioAutenticadoServicio obtenerUsuarioAutenticadoServicio;

    @Autowired
    public ObtenerUsuarioAutenticadoControlador(ObtenerUsuarioAutenticadoServicio obtenerUsuarioAutenticadoServicio){
        this.obtenerUsuarioAutenticadoServicio = obtenerUsuarioAutenticadoServicio;
    }

    @GetMapping(value = "/obtener/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable String id) {

        try {
            Optional<Usuario> usuario = obtenerUsuarioAutenticadoServicio.obtenerUsuarioPorId(id);

            if (usuario.isPresent()) {
                return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
        }

        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al obtener el usuario autenticado"+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
