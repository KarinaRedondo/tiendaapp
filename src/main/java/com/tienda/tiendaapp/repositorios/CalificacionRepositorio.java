package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CalificacionRepositorio extends MongoRepository<Calificacion, String> {
    List<Calificacion> findByIdTienda(String idTienda);
    List<Calificacion> findByIdDomiciliario(String idDomiciliario);
}
