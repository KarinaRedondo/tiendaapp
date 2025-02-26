package com.tienda.tiendaapp.servicios.Tienda;

import com.tienda.tiendaapp.dtos.tienda.CrearTiendaDto;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CrearTiendaServicio {

private final TiendaRepositorio tiendaRepositorio;

@Autowired
    public CrearTiendaServicio(TiendaRepositorio tiendaRepositorio) {
    this.tiendaRepositorio = tiendaRepositorio;
}

public Tienda crearTienda(CrearTiendaDto crearTiendaDto) {

    Tienda tienda = new Tienda();
    tienda.setNombre(crearTiendaDto.getNombre());
    tienda.setDireccion(crearTiendaDto.getDireccion());
    tienda.setTelefono(crearTiendaDto.getTelefono());
    tienda.setIdTendero(crearTiendaDto.getIdTendero());
    tienda.setCatalogoBasico(crearTiendaDto.getCatalogoBasico());
    tienda.setTotalVentas(crearTiendaDto.getTotalVentas());

    return tiendaRepositorio.save(tienda);
}
}
