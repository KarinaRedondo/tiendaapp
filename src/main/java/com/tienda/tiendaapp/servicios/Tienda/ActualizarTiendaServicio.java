package com.tienda.tiendaapp.servicios.Tienda;

import com.tienda.tiendaapp.dtos.tienda.ActualizarTiendaDto;
import com.tienda.tiendaapp.entidades.Tienda;
import com.tienda.tiendaapp.repositorios.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ActualizarTiendaServicio {

    private final TiendaRepositorio tiendaRepositorio;

    @Autowired
    public  ActualizarTiendaServicio(TiendaRepositorio tiendaRepositorio) {
        this.tiendaRepositorio = tiendaRepositorio;
    }

    public Tienda actualizarTienda(ActualizarTiendaDto actualizarTiendaDto) {
        List<Tienda> listaDeTiendas = tiendaRepositorio.findAll();
        Tienda tiendaEncontrada = null;

        for (Tienda tienda : listaDeTiendas) {
            if (tienda.getId().equals(actualizarTiendaDto.getId()));
            tiendaEncontrada = tienda;
            break;
        }

        if (tiendaEncontrada != null) {
            tiendaEncontrada.setNombre(actualizarTiendaDto.getNombre());
            tiendaEncontrada.setDireccion(actualizarTiendaDto.getDireccion());
            tiendaEncontrada.setTelefono(actualizarTiendaDto.getTelefono());
            tiendaEncontrada.setIdTendero(actualizarTiendaDto.getIdTendero());
            tiendaEncontrada.setCatalogoBasico(actualizarTiendaDto.getCatalogoBasico());
            tiendaEncontrada.setTotalVentas(actualizarTiendaDto.getTotalVentas());

            return  tiendaRepositorio.save(tiendaEncontrada);
    }
        else {
            return null;
        }
    }
}
