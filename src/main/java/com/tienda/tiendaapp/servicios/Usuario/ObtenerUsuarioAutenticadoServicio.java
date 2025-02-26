package com.tienda.tiendaapp.servicios.Usuario;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ObtenerUsuarioAutenticadoServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Optional<Usuario> obtenerUsuarioPorId(String id) {
        return usuarioRepositorio.findById(id);
    }
}
