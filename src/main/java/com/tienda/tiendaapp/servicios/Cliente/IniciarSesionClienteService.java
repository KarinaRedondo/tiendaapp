package com.tienda.tiendaapp.servicios.Cliente;
import com.tienda.tiendaapp.dtos.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Cliente;
import com.tienda.tiendaapp.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class IniciarSesionClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyección del encoder

    public Cliente ejecutar(IniciarSesionDto iniciarSesionDto) {
        // Buscar el cliente por correo
        Optional<Cliente> clienteOptional = clienteRepositorio.findByCorreo(iniciarSesionDto.getCorreo());

        if (clienteOptional.isEmpty()) {
            throw new IllegalArgumentException("Correo o contraseña incorrectos.");
        }

        Cliente cliente = clienteOptional.get();

        // Verificar si la contraseña coincide
        if (!passwordEncoder.matches(iniciarSesionDto.getPassword(), cliente.getPassword())) {
            throw new IllegalArgumentException("Correo o contraseña incorrectos.");
        }
        // Si todo está bien, devolver el cliente
        return cliente;
    }
}