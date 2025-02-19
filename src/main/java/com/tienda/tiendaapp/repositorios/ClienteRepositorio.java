package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ClienteRepositorio extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCorreo(String correo);
}
