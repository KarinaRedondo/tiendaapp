package com.tienda.tiendaapp.controladores.Auth.Tendero;

import com.tienda.tiendaapp.dtos.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Tendero;
import com.tienda.tiendaapp.servicios.Tendero.IniciarSesionTenderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/ v1")

public class IniciarSesionTenderoControlador {

    private final IniciarSesionTenderoService iniciarSesionTenderoService;

    @Autowired
    public IniciarSesionTenderoControlador(IniciarSesionTenderoService iniciarSesionTenderoService) {
        this.iniciarSesionTenderoService = iniciarSesionTenderoService;
    }
    @PostMapping(value = "/iniciar-sesion", headers = "Accept=application/json")
    public ResponseEntity<?> iniciarSesionControlador (@RequestBody IniciarSesionDto iniciarSesionDto) {

        try {
            Tendero tendero = iniciarSesionTenderoService.ejecutar(iniciarSesionDto);

            if (tendero == null){
                return new ResponseEntity<>("Crendenciales incorrectas", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(tendero, HttpStatus.OK);
            }
        catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de iniciar sesion" + exception.getMessage();

            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        }
    }
}
