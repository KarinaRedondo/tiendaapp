package com.tienda.tiendaapp.servicios.Vehiculo;

import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ListarVehiculoServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    public  ListarVehiculoServicio(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepositorio.findAll();
    }
}
