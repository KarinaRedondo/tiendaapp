package com.tienda.tiendaapp.servicios.Domiciliario;
import com.tienda.tiendaapp.entidades.Domiciliario;
import com.tienda.tiendaapp.repositorios.DomiciliarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class IniciarSesionDomiciliarioService {

    @Autowired
    private DomiciliarioRepositorio domiciliarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Domiciliario ejecutar(String correo, String password) {
        Optional<Domiciliario> domiciliarioOptional = domiciliarioRepositorio.findByCorreo(correo);

        if (domiciliarioOptional.isEmpty()) {
            throw new IllegalArgumentException("Correo o contraseña incorrectos.");
        }

        Domiciliario domiciliario = domiciliarioOptional.get();

        if (!passwordEncoder.matches(password, domiciliario.getPassword())) {
            throw new IllegalArgumentException("Correo o contraseña incorrectos.");
        }
        return domiciliario;
    }
}
