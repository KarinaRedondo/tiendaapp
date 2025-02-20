package com.tienda.tiendaapp.controladores.Auth.Tendero;

import com.tienda.tiendaapp.dtos.CrearTenderoDto;
import com.tienda.tiendaapp.entidades.Tendero;
import com.tienda.tiendaapp.servicios.Tendero.RegistrarTenderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/ap1/v1")
public class RegistrarTenderoControlador {

    private RegistrarTenderoService registrarTenderoService;

    @Autowired
    public RegistrarTenderoControlador (RegistrarTenderoService registrarTenderoService) {
        this.registrarTenderoService= registrarTenderoService;

}
@PostMapping (value ="/tenderos" , headers = "Accept=application/json")
public ResponseEntity<?> crearUsurarioControlador (@RequestBody CrearTenderoDto crearTenderoDto){

        try {
            System.out.println("Datos recibidos" + crearTenderoDto.toString());
            Tendero tendero = registrarTenderoService.ejecutar(crearTenderoDto);
            return new ResponseEntity<>(tendero, HttpStatus.OK);

        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear el usuario" + exception.getMessage();

            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

}
}
