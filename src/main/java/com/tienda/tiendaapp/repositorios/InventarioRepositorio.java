package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventarioRepositorio extends MongoRepository <Inventario, String> {
}
