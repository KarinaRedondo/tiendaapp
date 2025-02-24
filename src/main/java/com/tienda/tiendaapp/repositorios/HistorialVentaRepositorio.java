package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.HistorialVenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistorialVentaRepositorio extends MongoRepository<HistorialVenta, String> {
}
