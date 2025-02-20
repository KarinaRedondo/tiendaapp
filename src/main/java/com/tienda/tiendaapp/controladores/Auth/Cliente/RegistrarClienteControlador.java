package com.tienda.tiendaapp.controladores.Auth.Cliente;

import com.tienda.tiendaapp.dtos.CrearClienteDto;
import com.tienda.tiendaapp.entidades.Cliente;
import com.tienda.tiendaapp.servicios.Auth.RegistrarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegistrarClienteControlador {
    private RegistrarClienteService registrarClienteService;

    @Autowired
    public RegistrarClienteControlador(RegistrarClienteService registrarClienteService) {
        this.registrarClienteService = registrarClienteService;
    }

    @PostMapping(value = "/clientes", headers = "Accept=application/json")
    public ResponseEntity<?> crearUsuarioControlador(@RequestBody CrearClienteDto crearClienteDto) {
        try {
            System.out.println("Datos recibidos: " + crearClienteDto.toString());
            Cliente cliente = registrarClienteService.ejecutar(crearClienteDto);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear el usuario" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
