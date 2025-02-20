package com.tienda.tiendaapp.servicios.Tendero;
import com.tienda.tiendaapp.dtos.CrearTenderoDto;
import com.tienda.tiendaapp.entidades.Tendero;
import com.tienda.tiendaapp.repositorios.TenderoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class RegistrarTenderoService {

    @Autowired
    private TenderoRepositorio tenderoRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Tendero ejecutar(CrearTenderoDto crearTenderoDto) {
        Optional<Tendero> tenderoExistente = tenderoRepositorio.findByCorreo(crearTenderoDto.getCorreo());

        if (tenderoExistente.isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado. ");
        }

        Tendero tendero = new Tendero();
        tendero.setRol(crearTenderoDto.getRol());
        tendero.setNombreCompleto(crearTenderoDto.getNombreCompleto());
        tendero.setCorreo(crearTenderoDto.getCorreo());
        tendero.setPassword(passwordEncoder.encode(crearTenderoDto.getPassword()));
        tendero.setTelefono(crearTenderoDto.getTelefono());
        tendero.setNombreDeLaTienda(crearTenderoDto.getNombreDeLaTienda());
        tendero.setDireccionTienda(crearTenderoDto.getDireccionTienda());
        tendero.setTelefonoTienda(crearTenderoDto.getTelefonoTienda());
        tendero.setHistorialPedidosAtendidos(crearTenderoDto.getHistorialPedidosAtendidos());

        return tenderoRepositorio.save(tendero);
    }
}
