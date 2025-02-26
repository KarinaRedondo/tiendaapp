package com.tienda.tiendaapp.servicios.Tienda;

import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EliminarTiendaServicio {

    private final TiendaRepositorio tiendaRepositorio;

    @Autowired
    public EliminarTiendaServicio(TiendaRepositorio tiendaRepositorio) {
        this.tiendaRepositorio = tiendaRepositorio;
    }

    public boolean eliminarTienda(String id) {
        Optional<Tienda> tiendaOptional = tiendaRepositorio.findById(id);

        if (tiendaOptional.isPresent()) {
            tiendaRepositorio.delete(tiendaOptional.get());
            return true;
        }
        else {
            return false;
        }
    }
}
