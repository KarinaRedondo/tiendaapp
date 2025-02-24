package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculoRepositorio extends MongoRepository<Vehiculo, String> {
}
