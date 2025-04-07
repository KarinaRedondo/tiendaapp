package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GananciaDomiciliarioRepositorio extends MongoRepository<GananciaDomiciliario, String> {
    GananciaDomiciliario findByIdDomiciliario(String idDomiciliario);

    List<GananciaDomiciliario> findByIdDomiciliarioAndFechaVentaBetween(String idDomiciliario, String fechaInicio, String fechaFin);
}
