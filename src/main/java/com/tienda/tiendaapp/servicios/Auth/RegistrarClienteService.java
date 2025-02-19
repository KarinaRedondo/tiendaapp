package com.tienda.tiendaapp.servicios.Auth;

import com.tienda.tiendaapp.entidades.Cliente;
import com.tienda.tiendaapp.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrarClienteService {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyección del encoder

    public Cliente ejecutar(Cliente cliente) {
        // Verificar si el correo ya está registrado
        Optional<Cliente> clienteExistente = clienteRepositorio.findByCorreo(cliente.getCorreo());

        if (clienteExistente.isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // Encriptar la contraseña antes de guardar el usuario
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        return clienteRepositorio.save(cliente);
    }
}
