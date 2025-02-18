package com.tienda.tiendaapp.repositorios;
import com.tienda.tiendaapp.entidades.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepositorio extends MongoRepository <Cliente, String> {
}
