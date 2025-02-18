package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Pedidos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidosRepositorio extends MongoRepository <Pedidos, String>{
}
