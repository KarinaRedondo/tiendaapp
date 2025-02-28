package com.tienda.tiendaapp.servicios.Calificacion;

import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.repositorios.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ListarCalificacionServicio {

    private final CalificacionRepositorio calificacionRepositorio;

    @Autowired
    public ListarCalificacionServicio(CalificacionRepositorio calificacionRepositorio) {
        this.calificacionRepositorio = calificacionRepositorio;
    }

    public List<Calificacion> listarCalificaciones() {
        return calificacionRepositorio.findAll();
    }
}
