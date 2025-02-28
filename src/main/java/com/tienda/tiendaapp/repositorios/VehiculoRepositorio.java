package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehiculoRepositorio extends MongoRepository<Vehiculo, String> {
    List<Vehiculo> findByIdDomiciliario(String id);
}
