package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepositorio extends MongoRepository<Pedido, String> {
    List<Pedido> findByEstado(String estado);
    List<Pedido> findByIdClienteAndEstado(String idCliente, String estado);
    List<Pedido> findByIdTiendaAndEstado(String idTienda, String estado);
}
