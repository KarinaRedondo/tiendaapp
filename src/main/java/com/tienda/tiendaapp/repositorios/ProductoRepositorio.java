package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepositorio extends MongoRepository <Producto, String> {
}
