package com.tienda.tiendaapp.servicios.Usuario;

import com.tienda.tiendaapp.dtos.usuario.CrearUsuarioDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearUsuarioServicio {

        private final UsuarioRepositorio usuarioRepositorio;

        @Autowired
        public CrearUsuarioServicio (UsuarioRepositorio usuarioRepositorio){
            this.usuarioRepositorio = usuarioRepositorio;
        }

        public Usuario crearUsuario(CrearUsuarioDto crearUsuarioDto){
            Usuario usuario = new Usuario();
            usuario.setNombreCompleto(crearUsuarioDto.getNombreCompleto());
            usuario.setCorreo(crearUsuarioDto.getCorreo());
            usuario.setContraseña(crearUsuarioDto.getContraseña());
            usuario.setRol(crearUsuarioDto.getRol());
            usuario.setEstado(crearUsuarioDto.getEstado());

            return usuarioRepositorio.save(usuario);
        }
    }


