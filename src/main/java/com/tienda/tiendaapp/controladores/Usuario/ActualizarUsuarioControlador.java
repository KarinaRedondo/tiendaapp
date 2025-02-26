package com.tienda.tiendaapp.controladores.Usuario;

import com.tienda.tiendaapp.dtos.usuario.ActualizarUsuarioDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.servicios.Usuario.ActualizarUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")

public class ActualizarUsuarioControlador {

    private final ActualizarUsuarioServicio actualizarUsuarioServicio;

    @Autowired
    public ActualizarUsuarioControlador(ActualizarUsuarioServicio actualizarUsuarioServicio) {
        this.actualizarUsuarioServicio = actualizarUsuarioServicio;
    }

    @PutMapping(value = "/actualizar", headers = "Accept=application/json")
    public ResponseEntity<?> actualizarUsuario(@RequestBody ActualizarUsuarioDto actualizarUsuarioDto) {

        try {
            Usuario usuarioActualizado = actualizarUsuarioServicio.actualizarUsuario(actualizarUsuarioDto);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de actualizar el usuario" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
