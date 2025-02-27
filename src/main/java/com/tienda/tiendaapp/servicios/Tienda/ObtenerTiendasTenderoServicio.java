package com.tienda.tiendaapp.servicios.Tienda;

import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ObtenerTiendasTenderoServicio {

    private final TiendaRepositorio tiendaRepositorio;

    @Autowired
    public  ObtenerTiendasTenderoServicio(TiendaRepositorio tiendaRepositorio) {
        this.tiendaRepositorio = tiendaRepositorio;
    }

    public List<Tienda> obtenerTiendasPorIdTendero(String id) {
        return tiendaRepositorio.findByIdTendero(id);
    }
}
