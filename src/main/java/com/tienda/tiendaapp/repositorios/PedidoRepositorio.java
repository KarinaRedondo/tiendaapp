package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepositorio extends MongoRepository<Pedido, String> {
}
