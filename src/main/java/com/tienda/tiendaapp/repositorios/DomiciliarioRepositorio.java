package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Domiciliario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomiciliarioRepositorio extends MongoRepository <Domiciliario, String> {
}
