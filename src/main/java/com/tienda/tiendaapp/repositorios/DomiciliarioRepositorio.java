package com.tienda.tiendaapp.repositorios;
import com.tienda.tiendaapp.entidades.Domiciliario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DomiciliarioRepositorio extends MongoRepository <Domiciliario, String> {
    Optional<Domiciliario> findByCorreo(String correo);
}
