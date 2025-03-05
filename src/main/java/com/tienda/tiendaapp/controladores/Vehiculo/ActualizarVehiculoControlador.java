package com.tienda.tiendaapp.controladores.Vehiculo;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.tienda.tiendaapp.dtos.vehiculo.ActualizarVehiculoDto;
import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.servicios.Vehiculo.ActualizarVehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class ActualizarVehiculoControlador {

    private final ActualizarVehiculoServicio actualizarVehiculoServicio;

@Autowired
public ActualizarVehiculoControlador(ActualizarVehiculoServicio actualizarVehiculoServicio) {
    this.actualizarVehiculoServicio = actualizarVehiculoServicio;
}

@PutMapping(value = "/vehiculos/actualizar", headers = "Accept=application/json")
public ResponseEntity<?> actualizarVehiculo(@RequestBody ActualizarVehiculoDto  actualizarVehiculoDto) {

    try{
        Vehiculo vehiculoActualizado = actualizarVehiculoServicio.actualizarVehiculo(actualizarVehiculoDto);
        return new ResponseEntity<>(vehiculoActualizado, HttpStatus.OK);
    }
    catch (Exception exception){
        String mensajeDeError = "Hubo un error al tratar de actualizar el vehiculo: " + exception.getMessage();
        return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
