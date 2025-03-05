package com.tienda.tiendaapp.controladores.Vehiculo;


import com.tienda.tiendaapp.dtos.vehiculo.CrearVehiculoDto;
import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.servicios.Vehiculo.RegistrarVehículoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class RegistrarVehiculoControlador {

    private final RegistrarVehículoServicio registrarVehículoServicio;

    @Autowired
    public RegistrarVehiculoControlador(RegistrarVehículoServicio registrarVehículoServicio) {
       this.registrarVehículoServicio = registrarVehículoServicio;
    }

    @PostMapping(value= "/vehiculos/registrar", headers = "Accept=application/json")
    public ResponseEntity<?> registrarVehiculo(@RequestBody CrearVehiculoDto crearVehiculoDto) {

        try {
            Vehiculo vehiculoCreado = registrarVehículoServicio.registrarVehiculo(crearVehiculoDto);
            return new ResponseEntity<>(vehiculoCreado, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de registrar el vehiculo: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}