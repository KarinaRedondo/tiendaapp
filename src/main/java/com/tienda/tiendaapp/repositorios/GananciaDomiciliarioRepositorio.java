package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GananciaDomiciliarioRepositorio extends MongoRepository<GananciaDomiciliario, String> {
    GananciaDomiciliario findByIdDomiciliario(String idDomiciliario);
}
