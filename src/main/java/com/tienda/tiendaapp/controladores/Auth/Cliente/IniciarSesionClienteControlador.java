package com.tienda.tiendaapp.controladores.Auth.Cliente;

import com.tienda.tiendaapp.dtos.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Cliente;
import com.tienda.tiendaapp.servicios.Cliente.IniciarSesionClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")

public class IniciarSesionClienteControlador {

    private final IniciarSesionClienteService iniciarSesionClienteService;

    @Autowired
    public IniciarSesionClienteControlador(IniciarSesionClienteService iniciarSesionClienteService) {
        this.iniciarSesionClienteService = iniciarSesionClienteService;
    }

    @PostMapping(value = "/iniciar-sesion", headers = "Accept=application/json")
    public ResponseEntity<?> iniciarSesionControlador(@RequestBody IniciarSesionDto iniciarSesionDto) {
        try {
            Cliente cliente = iniciarSesionClienteService.ejecutar(iniciarSesionDto);

            // Si no hay un usuario logueado, retorna un código 401
            if (cliente == null) {
                return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
            }

            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de iniciar sesión: " + exception.getMessage();

            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}