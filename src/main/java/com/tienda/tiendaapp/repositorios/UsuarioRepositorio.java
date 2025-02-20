package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByCorreo(String correo);
}
