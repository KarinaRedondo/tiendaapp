package com.tienda.tiendaapp.servicios.Auth;

import com.tienda.tiendaapp.dtos.CrearClienteDto;
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

    public Cliente ejecutar(CrearClienteDto crearClienteDto) {
        // Verificar si el correo ya está registrado
        Optional<Cliente> clienteExistente = clienteRepositorio.findByCorreo(crearClienteDto.getCorreo());

        if (clienteExistente.isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // Convertir DTO a entidad Cliente
        Cliente cliente = new Cliente();
        cliente.setRol(crearClienteDto.getRol());
        cliente.setNombreCompleto(crearClienteDto.getNombreCompleto());
        cliente.setCorreo(crearClienteDto.getCorreo());
        cliente.setPassword(passwordEncoder.encode(crearClienteDto.getPassword()));
        cliente.setTelefono(crearClienteDto.getTelefono());
        cliente.setMetodoDePagoPreferido(crearClienteDto.getMetodoDePagoPreferido());
        cliente.setDireccion(crearClienteDto.getDireccion());
        cliente.setHistorialDePedidos(crearClienteDto.getHistorialDePedidos());

        return clienteRepositorio.save(cliente);
    }
}
