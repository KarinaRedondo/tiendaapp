package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Tienda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TiendaRepositorio extends MongoRepository<Tienda, String> {
}
