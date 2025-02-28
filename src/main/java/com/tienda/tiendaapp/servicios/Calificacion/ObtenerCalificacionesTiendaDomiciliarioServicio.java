package com.tienda.tiendaapp.servicios.Calificacion;

import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.repositorios.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ObtenerCalificacionesTiendaDomiciliarioServicio {

    private final CalificacionRepositorio calificacionRepositorio;

    @Autowired
    public ObtenerCalificacionesTiendaDomiciliarioServicio(CalificacionRepositorio calificacionRepositorio) {
        this.calificacionRepositorio = calificacionRepositorio;
    }

    public List<Integer> obtenerCalificacionTienda(String idTienda) {
        List<Calificacion> calificaciones = calificacionRepositorio.findByIdTienda(idTienda);
        return calificaciones.stream()
                .map(Calificacion::getCalificacionTienda)
                .collect(Collectors.toList());
    }

    public List<Integer> obtenerCalificacionDomiciliario(String idDomiciliario) {
        List<Calificacion> calificaciones = calificacionRepositorio.findByIdDomiciliario(idDomiciliario);
        return calificaciones.stream()
                .map(Calificacion::getCalificacionDomiciliario)
                .collect(Collectors.toList());
    }
}
