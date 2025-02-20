package com.tienda.tiendaapp.controladores.Auth.Domiciliario;

import com.tienda.tiendaapp.entidades.Domiciliario;
import com.tienda.tiendaapp.servicios.Domiciliario.RegistrarDomiciliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tienda.tiendaapp.dtos.CrearDomiciliarioDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class RegistrarDomiciliarioControlador {

    private RegistrarDomiciliarioService registrarDomiciliarioService;

    @Autowired
    public RegistrarDomiciliarioControlador(RegistrarDomiciliarioService registrarDomiciliarioService) {
        this.registrarDomiciliarioService = registrarDomiciliarioService;
    }

    @PostMapping(value = "/domiciliarios", headers = "Accept=application/json")
    public ResponseEntity<?> crearUsuarioControlador(@RequestBody CrearDomiciliarioDto crearDomiciliarioDto) {

        try {
            System.out.println("Datos recibidos " + crearDomiciliarioDto.toString());
            Domiciliario domiciliario = registrarDomiciliarioService.ejecutar(crearDomiciliarioDto);
            return new ResponseEntity<>(domiciliario, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear el usuario" + exception.getMessage();

            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
