package com.tienda.tiendaapp.servicios.Domiciliario;

import com.tienda.tiendaapp.dtos.CrearDomiciliarioDto;
import com.tienda.tiendaapp.entidades.Domiciliario;
import com.tienda.tiendaapp.repositorios.DomiciliarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class RegistrarDomiciliarioService {

    @Autowired
    private DomiciliarioRepositorio domiciliarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Domiciliario ejecutar(CrearDomiciliarioDto crearDomiciliarioDto) {
        Optional<Domiciliario> domiciliarioExistente = domiciliarioRepositorio.findByCorreo(crearDomiciliarioDto.getCorreo());

        if (domiciliarioExistente.isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado. ");
        }
        Domiciliario domiciliario = new Domiciliario();
        domiciliario.setRol(crearDomiciliarioDto.getRol());
        domiciliario.setNombreCompleto(crearDomiciliarioDto.getNombreCompleto());
        domiciliario.setCorreo(crearDomiciliarioDto.getCorreo());
        domiciliario.setPassword(passwordEncoder.encode(crearDomiciliarioDto.getPassword()));
        domiciliario.setTelefono(crearDomiciliarioDto.getTelefono());
        domiciliario.setTipoDeVehiculo(crearDomiciliarioDto.getTipoDeVehiculo());
        domiciliario.setPlacaDelVehiculo(crearDomiciliarioDto.getPlacaDelVehiculo());
        domiciliario.setEntregasTotales(crearDomiciliarioDto.getEntregasTotales());
        domiciliario.setCalificacionPromedio(crearDomiciliarioDto.getCalificacionPromedio());
        domiciliario.setGananciasTotales(crearDomiciliarioDto.getGananciasTotales());
        domiciliario.setEstadoDeDisponibilidad(crearDomiciliarioDto.isEstadoDeDisponibilidad());

        return domiciliarioRepositorio.save(domiciliario);
    }
}
