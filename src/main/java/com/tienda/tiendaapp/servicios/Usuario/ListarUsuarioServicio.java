package com.tienda.tiendaapp.servicios.Usuario;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ListarUsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public ListarUsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}
