package com.tienda.tiendaapp.servicios.Domiciliario;
import com.tienda.tiendaapp.entidades.Domiciliario;
import com.tienda.tiendaapp.repositorios.DomiciliarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RegistrarDomiciliario {

    @Autowired
    private DomiciliarioRepositorio domiciliarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Domiciliario ejecutar(Domiciliario domiciliario) {
        Optional<Domiciliario> domiciliarioExistente = domiciliarioRepositorio.findByCorreo(domiciliario.getCorreo());

        if (domiciliarioExistente.isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado. ");
        }

        domiciliario.setPassword(passwordEncoder.encode(domiciliario.getPassword()));
        return domiciliarioRepositorio.save(domiciliario);
    }
}
