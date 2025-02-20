package com.tienda.tiendaapp.controladores.Auth.Domiciliario;

import com.tienda.tiendaapp.dtos.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Domiciliario;
import com.tienda.tiendaapp.servicios.Domiciliario.IniciarSesionDomiciliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class IniciarSesionDomiciliarioControlador {

    private final IniciarSesionDomiciliarioService iniciarSesionDomiciliarioService;

    @Autowired
    public IniciarSesionDomiciliarioControlador(IniciarSesionDomiciliarioService iniciarSesionDomiciliarioService) {
        this.iniciarSesionDomiciliarioService = iniciarSesionDomiciliarioService;
    }

    @PostMapping(value = "/iniciar-sesion", headers = "Accept=application/json")
    public ResponseEntity<?> iniciarSesionControlador(@RequestBody IniciarSesionDto iniciarSesionDto) {

        try {
            Domiciliario domiciliario = iniciarSesionDomiciliarioService.ejecutar(iniciarSesionDto);

            if (domiciliario == null) {
                return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(domiciliario, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de iniciar sesion " + exception.getMessage();

            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
