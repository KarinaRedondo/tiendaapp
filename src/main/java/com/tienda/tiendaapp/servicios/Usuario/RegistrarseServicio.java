package com.tienda.tiendaapp.servicios.Usuario;
import com.tienda.tiendaapp.dtos.RegistrarseDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service

    public class RegistrarseServicio {

        private final UsuarioRepositorio usuarioRepositorio;

        @Autowired

        public RegistrarseServicio(UsuarioRepositorio usuarioRepositorio) {
            this.usuarioRepositorio = usuarioRepositorio;
        }

        public Usuario crearUsuario(RegistrarseDto registrarseDto) {
            Usuario usuario = new Usuario();
            usuario.getRol();
            usuario.getNombreCompleto();
            usuario.getcorreo();
            usuario.getContraseña();
            usuario.getTelefono();

            return usuarioRepositorio.save(usuario);
        }
    }
