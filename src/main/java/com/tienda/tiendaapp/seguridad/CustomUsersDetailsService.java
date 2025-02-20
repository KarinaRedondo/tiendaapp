package com.tienda.tiendaapp.seguridad;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomUsersDetailsService implements UserDetailsService {

    private UsuarioRepositorio usuariosRepo;

    @Autowired
    public CustomUsersDetailsService(UsuarioRepositorio usuariosRepo) {
        this.usuariosRepo = usuariosRepo;
    }

    // Método para traernos un usuario con todos sus datos por medio de su correo electrónico
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuarios = usuariosRepo.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(usuarios.getCorreo(), usuarios.getPassword(), new ArrayList<>());
    }
}
