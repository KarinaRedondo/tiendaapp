package com.tienda.tiendaapp.controladores.Vehiculo;

import com.tienda.tiendaapp.servicios.Vehiculo.EliminarVehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class EliminarVehiculoControlador {

    private final EliminarVehiculoServicio eliminarVehiculoServicio;

    @Autowired
    public EliminarVehiculoControlador(EliminarVehiculoServicio eliminarVehiculoServicio){
        this.eliminarVehiculoServicio = eliminarVehiculoServicio;
    }

    @DeleteMapping(value = "/vehiculos/eliminar/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> eliminarVehiculo(@PathVariable("id") String id){

        try {
            boolean respuesta = eliminarVehiculoServicio.eliminarVehiculo(id);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }
        catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de eliminar el vehiculo:" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
