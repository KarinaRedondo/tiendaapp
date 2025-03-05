package com.tienda.tiendaapp.controladores.Vehiculo;

import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.servicios.Vehiculo.ObtenerVehiculosDelDomiciliarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class ObtenerVehiculosDelDomiciliarioControlador {

    private final ObtenerVehiculosDelDomiciliarioServicio obtenerVehiculosDelDomiciliarioServicio;

    @Autowired
    public ObtenerVehiculosDelDomiciliarioControlador(ObtenerVehiculosDelDomiciliarioServicio obtenerVehiculosDelDomiciliarioServicio) {
        this.obtenerVehiculosDelDomiciliarioServicio = obtenerVehiculosDelDomiciliarioServicio;
    }

    @GetMapping(value = "/vehiculos/obtenerVehiculos-domiciliario/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> obtenervehiculos(@PathVariable String id) {
        List<Vehiculo> vehiculos = obtenerVehiculosDelDomiciliarioServicio.obtenerVehiculosPorIdDomiciliario(id);

        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>("No se pueden obtener los vehiculos para este domiciliario", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }
}
