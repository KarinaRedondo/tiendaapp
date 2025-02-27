package com.tienda.tiendaapp.servicios.Vehiculo;

import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EliminarVehiculoServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    public EliminarVehiculoServicio(VehiculoRepositorio vehiculoRepositorio){
        this.vehiculoRepositorio = vehiculoRepositorio;
    }
    public boolean eliminarVehiculo(String id){
        Optional<Vehiculo> vehiculoOptional = vehiculoRepositorio.findById(id);

        if (vehiculoOptional.isPresent()) {
            vehiculoRepositorio.delete(vehiculoOptional.get());
            return true;
        }
        else {
            return false;
        }
    }
}
