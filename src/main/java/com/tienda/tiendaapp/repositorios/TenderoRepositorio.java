package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Tendero;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TenderoRepositorio extends MongoRepository<Tendero, String> {
    Optional<Tendero> findByCorreo(String correo);
}
