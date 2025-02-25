package com.tienda.tiendaapp.servicios.Usuario;

import com.tienda.tiendaapp.dtos.usuario.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class IniciarSesionServicio {
    private static final Logger logger = LoggerFactory.getLogger(IniciarSesionServicio.class);
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public IniciarSesionServicio (UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario IniciarSesion(IniciarSesionDto iniciarSesionDto){
        String correo = iniciarSesionDto.getCorreo();
        String contraseña = iniciarSesionDto.getContraseña();

        logger.info("Iniciando sesión para el correo: {}", correo);

        Optional<Usuario>usuarioOpt= usuarioRepositorio.findByCorreo(correo);

        logger.info("info encontrada: {}", usuarioOpt);

        if (!usuarioOpt.isPresent()){
            logger.error("Usuario no encontrado para el correo: {}", correo);
            throw new IllegalArgumentException("Usuario no encontrado para el correo proporcionado.");

        }

        Usuario usuarioEncontrado = usuarioOpt.get();

        if (contraseña.equals(usuarioEncontrado.getContraseña())) {
            logger.info("Usuario autenticado exitosamente: {}", usuarioEncontrado.getNombreCompleto());
            return usuarioEncontrado;
        }else {
            logger.error("Contraseña incorrecta para el usuario {}", correo);
            throw new IllegalArgumentException("Contraseña incorrecta");
        }
    }
}
