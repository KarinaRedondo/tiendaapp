package com.tienda.tiendaapp.servicios.Usuario;

import com.tienda.tiendaapp.dtos.usuario.ActualizarUsuarioDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ActualizarUsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public ActualizarUsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
    this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario actualizarUsuario(ActualizarUsuarioDto actualizarUsuarioDto) {
        List<Usuario> listaDeUsuarios = usuarioRepositorio.findAll();
        Usuario usuarioEncontrado = null;

        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getId().equals(actualizarUsuarioDto.getId())) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            usuarioEncontrado.setNombreCompleto(actualizarUsuarioDto.getNombreCompleto());
            usuarioEncontrado.setCorreo(actualizarUsuarioDto.getCorreo());
            usuarioEncontrado.setContraseña(actualizarUsuarioDto.getContraseña());
            usuarioEncontrado.setRol(actualizarUsuarioDto.getRol());
           usuarioEncontrado.setEstado(actualizarUsuarioDto.getEstado());

           return usuarioRepositorio.save(usuarioEncontrado);
        }
        else {
            return null;
        }
    }
}
