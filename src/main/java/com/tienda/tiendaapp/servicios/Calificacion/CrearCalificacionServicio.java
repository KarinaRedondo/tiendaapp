package com.tienda.tiendaapp.servicios.Calificacion;

import com.tienda.tiendaapp.dtos.calificacion.CrearCalificacionDto;
import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.repositorios.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CrearCalificacionServicio {

    private final CalificacionRepositorio calificacionRepositorio;

    @Autowired
    public CrearCalificacionServicio(CalificacionRepositorio calificacionRepositorio) {
        this.calificacionRepositorio = calificacionRepositorio;
    }

    public Calificacion crearCalificacion(CrearCalificacionDto crearCalificacionDto) {

        Calificacion calificacion = new Calificacion();
        calificacion.setIdPedido(crearCalificacionDto.getIdPedido());
        calificacion.setIdCliente(crearCalificacionDto.getIdCliente());
        calificacion.setIdTienda(crearCalificacionDto.getIdTienda());
        calificacion.setCalificacionTienda(crearCalificacionDto.getCalificacionTienda());
        calificacion.setComentarioTienda(crearCalificacionDto.getComentarioTienda());
        calificacion.setRespuestaTendero(crearCalificacionDto.getRespuestaTendero());
        calificacion.setIdDomiciliario(crearCalificacionDto.getIdDomiciliario());
        calificacion.setCalificacionDomiciliario(crearCalificacionDto.getCalificacionDomiciliario());
        calificacion.setComentarioDomiciliario(crearCalificacionDto.getComentarioDomiciliario());
        calificacion.setRespuestaDomiciliario(crearCalificacionDto.getRespuestaDomiciliario());

        return calificacionRepositorio.save(calificacion);
    }
    }

