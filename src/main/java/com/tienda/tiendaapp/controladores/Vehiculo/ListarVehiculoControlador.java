package com.tienda.tiendaapp.controladores.Vehiculo;

import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.servicios.Vehiculo.ListarVehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculos")

public class ListarVehiculoControlador {

    private final ListarVehiculoServicio listarVehiculoServicio;

    @Autowired
    public ListarVehiculoControlador(ListarVehiculoServicio listarVehiculoServicio) {
        this.listarVehiculoServicio = listarVehiculoServicio;
    }

    @GetMapping(value = "/listar", headers = "Accept=application/json")
    public ResponseEntity<?> listarVehiculoControlador() {

        try {
            List<Vehiculo> listaVehiculosRetornada = listarVehiculoServicio.listarVehiculos();
            return new ResponseEntity<>(listaVehiculosRetornada, HttpStatus.OK);
        }
        catch (Exception  exception) {
            String mensajeDeError = "Hubo un error al tratar de obtener los vehiculos: "+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
