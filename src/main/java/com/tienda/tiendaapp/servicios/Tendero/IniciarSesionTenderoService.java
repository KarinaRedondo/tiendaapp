package com.tienda.tiendaapp.servicios.Tendero;
import com.tienda.tiendaapp.dtos.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Tendero;
import com.tienda.tiendaapp.repositorios.TenderoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class IniciarSesionTenderoService {

    @Autowired
    private TenderoRepositorio tenderoRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Tendero ejecutar(IniciarSesionDto iniciarSesionDto) {
        Optional<Tendero> tenderoOptional = tenderoRepositorio.findByCorreo(iniciarSesionDto.getCorreo());

        if (tenderoOptional.isEmpty()) {
            throw  new IllegalArgumentException("Correo o contraseña incorrectos.");
        }

        Tendero tendero = tenderoOptional.get();

        if (!passwordEncoder.matches(iniciarSesionDto.getPassword(), tendero.getPassword())) {
            throw new IllegalArgumentException("Correo o contraseña incorrectos.");
        }
        return tendero;
    }
}
