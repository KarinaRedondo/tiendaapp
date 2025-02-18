package com.tienda.tiendaapp.repositorios;
import com.tienda.tiendaapp.entidades.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalificacionRepositorio extends MongoRepository <Calificacion, String> {
}
