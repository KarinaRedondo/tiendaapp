package com.tienda.tiendaapp.servicios.Calificacion;

import com.tienda.tiendaapp.dtos.calificacion.ActualizarCalificacionDto;
import com.tienda.tiendaapp.entidades.Calificacion;
import com.tienda.tiendaapp.repositorios.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ActualizarCalificacionServicio {

    private final CalificacionRepositorio calificacionRepositorio;

    @Autowired
    public ActualizarCalificacionServicio(CalificacionRepositorio calificacionRepositorio) {
        this.calificacionRepositorio = calificacionRepositorio;
    }

    public Calificacion actualizarCalificacion(ActualizarCalificacionDto actualizarCalificacionDto) {
        List<Calificacion> listaDeCalificaciones = calificacionRepositorio.findAll();
        Calificacion calificacionEncontrada = null;

        for (Calificacion calificacion : listaDeCalificaciones) {
            if (calificacion.getId().equals(actualizarCalificacionDto.getId())) ;
            calificacionEncontrada = calificacion;
            break;
        }

        if (calificacionEncontrada != null) {
            calificacionEncontrada.setId(actualizarCalificacionDto.getId());
            calificacionEncontrada.setIdPedido(actualizarCalificacionDto.getIdPedido());
            calificacionEncontrada.setIdCliente(actualizarCalificacionDto.getIdCliente());
            calificacionEncontrada.setIdTienda(actualizarCalificacionDto.getIdTienda());
            calificacionEncontrada.setCalificacionTienda(actualizarCalificacionDto.getCalificacionTienda());
            calificacionEncontrada.setComentarioTienda(actualizarCalificacionDto.getComentarioTienda());
            calificacionEncontrada.setRespuestaTendero(actualizarCalificacionDto.getRespuestaTendero());
            calificacionEncontrada.setIdDomiciliario(actualizarCalificacionDto.getId());
            calificacionEncontrada.setCalificacionDomiciliario(actualizarCalificacionDto.getCalificacionDomiciliario());
            calificacionEncontrada.setComentarioDomiciliario(actualizarCalificacionDto.getComentarioDomiciliario());
            calificacionEncontrada.setRespuestaDomiciliario(actualizarCalificacionDto.getRespuestaTendero());

            return calificacionRepositorio.save(calificacionEncontrada);
        } else {
            return null;
        }
    }
}
