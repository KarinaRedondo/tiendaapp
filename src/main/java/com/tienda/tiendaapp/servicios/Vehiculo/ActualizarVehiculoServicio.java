package com.tienda.tiendaapp.servicios.Vehiculo;


import com.tienda.tiendaapp.dtos.vehiculo.ActualizarVehiculoDto;
import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import com.tienda.tiendaapp.repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ActualizarVehiculoServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    public ActualizarVehiculoServicio(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    public Vehiculo actualizarVehiculo(ActualizarVehiculoDto actualizarVehiculoDto) {
        List<Vehiculo> listasDeVehiculos = vehiculoRepositorio.findAll();
        Vehiculo vehiculoEncontrado = null;

        for (Vehiculo vehiculo : listasDeVehiculos) {
            if (vehiculo.getId().equals(actualizarVehiculoDto.getId())) ;
            vehiculoEncontrado = vehiculo;
            break;
        }

        if (vehiculoEncontrado != null) {
            vehiculoEncontrado.setId(actualizarVehiculoDto.getId());
            vehiculoEncontrado.setIdDomiciliario(actualizarVehiculoDto.getIdDomiciliario());
            vehiculoEncontrado.setTipo(actualizarVehiculoDto.getTipo());
            vehiculoEncontrado.setPlaca(actualizarVehiculoDto.getPlaca());
            vehiculoEncontrado.setMarca(actualizarVehiculoDto.getMarca());
            vehiculoEncontrado.setModelo(actualizarVehiculoDto.getModelo());
            vehiculoEncontrado.setCapacidadCarga(actualizarVehiculoDto.getCapacidadCarga());

            return vehiculoRepositorio.save(vehiculoEncontrado);
        } else {
            return null;
        }
    }
}