package com.tienda.tiendaapp.servicios.Vehiculo;

import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ObtenerVehiculosDelDomiciliarioServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    public ObtenerVehiculosDelDomiciliarioServicio(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    public Optional<Vehiculo> obtenerVehiculosPorIdDomiciliario(String id) {
        return vehiculoRepositorio.findById(id);
    }
}
