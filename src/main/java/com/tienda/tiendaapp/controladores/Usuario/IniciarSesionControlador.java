package com.tienda.tiendaapp.controladores.Usuario;

import com.tienda.tiendaapp.dtos.usuario.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.servicios.Usuario.IniciarSesionServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")

public class IniciarSesionControlador {

    private static final Logger logger = LoggerFactory.getLogger(IniciarSesionControlador.class);

    private final IniciarSesionServicio iniciarSesionServicio;

    @Autowired
    public IniciarSesionControlador(IniciarSesionServicio iniciarSesionServicio) {
        this.iniciarSesionServicio = iniciarSesionServicio;
    }

    @PostMapping(value = "/iniciar-sesion", headers = "Accept=application/json")
    public ResponseEntity<?> iniciarSesionControlador(@RequestBody IniciarSesionDto iniciarSesionDto) {
        try {
            Usuario usuarioLogueado = iniciarSesionServicio.IniciarSesion(iniciarSesionDto);

            if (usuarioLogueado == null) {
                return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
            }

            logger.info("Usuario autenticado exitosamente: {}", usuarioLogueado);
            return new ResponseEntity<>(usuarioLogueado, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de iniciar sesión: "+ exception.getMessage();
            logger.error("Error al intentar iniciar sesión: {}", exception.getMessage());
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}