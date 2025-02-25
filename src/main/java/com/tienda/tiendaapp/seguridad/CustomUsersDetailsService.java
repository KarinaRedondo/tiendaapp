package com.tienda.tiendaapp.seguridad;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUsersDetailsService implements UserDetailsService {

    private UsuarioRepositorio usuariosRepo;

    @Autowired
    public CustomUsersDetailsService(UsuarioRepositorio usuariosRepo) {
        this.usuariosRepo = usuariosRepo;
    }

    // Método para traernos un usuario con todos sus datos por medio de su correo electrónico
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuarios = usuariosRepo.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("CrearUsuarioDto no encontrado"));
        return new User(usuarios.getCorreo(), usuarios.getContraseña(), new ArrayList<>());
    }
}
