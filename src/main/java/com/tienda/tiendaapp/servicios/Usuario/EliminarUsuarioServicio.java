package com.tienda.tiendaapp.servicios.Usuario;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EliminarUsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public EliminarUsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public boolean eliminarUsuario(String id) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepositorio.delete(usuarioOptional.get());
            return true;
        }

        else {
            return false;
        }
    }
}
