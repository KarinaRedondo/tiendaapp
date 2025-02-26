package com.tienda.tiendaapp.servicios.Tienda;

import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ObtenerTiendaEspecificaServicio {

    @Autowired
    private TiendaRepositorio tiendaRepositorio;

    public Optional<Tienda> obtenerTiendaPoId(String id) {
        return tiendaRepositorio.findById(id);
    }
}
