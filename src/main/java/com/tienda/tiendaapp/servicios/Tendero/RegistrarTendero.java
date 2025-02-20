package com.tienda.tiendaapp.servicios.Tendero;
import com.tienda.tiendaapp.entidades.Tendero;
import com.tienda.tiendaapp.repositorios.TenderoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RegistrarTendero {

    @Autowired
    private TenderoRepositorio tenderoRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Tendero ejecutar(Tendero tendero) {
        Optional<Tendero> tenderoExistente = tenderoRepositorio.findByCorreo(tendero.getCorreo());

        if (tenderoExistente.isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado. ");
        }
        tendero.setPassword(passwordEncoder.encode(tendero.getPassword()));
        return tenderoRepositorio.save(tendero);
    }
}
