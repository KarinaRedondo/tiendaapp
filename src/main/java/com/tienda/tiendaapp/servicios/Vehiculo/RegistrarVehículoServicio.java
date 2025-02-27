package com.tienda.tiendaapp.servicios.Vehiculo;

import com.tienda.tiendaapp.dtos.vehiculo.CrearVehiculoDto;
import com.tienda.tiendaapp.entidades.Vehiculo;
import com.tienda.tiendaapp.repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RegistrarVehículoServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    @Autowired
        public RegistrarVehículoServicio(VehiculoRepositorio vehiculoRepositorio) { this.vehiculoRepositorio = vehiculoRepositorio; }

    public Vehiculo registrarVehiculo(CrearVehiculoDto crearVehiculoDto) {

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setIdDomiciliario(crearVehiculoDto.getIdDomiciliario());
        vehiculo.setTipo(crearVehiculoDto.getTipo());
        vehiculo.setPlaca(crearVehiculoDto.getPlaca());
        vehiculo.setMarca(crearVehiculoDto.getMarca());
        vehiculo.setModelo(crearVehiculoDto.getModelo());
        vehiculo.setCapacidadCarga(crearVehiculoDto.getCapacidadCarga());

        return vehiculoRepositorio.save(vehiculo);
    }
    }
