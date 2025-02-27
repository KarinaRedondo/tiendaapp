package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Tienda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TiendaRepositorio extends MongoRepository<Tienda, String> {
    List<Tienda> findByIdTendero(String id);
}
