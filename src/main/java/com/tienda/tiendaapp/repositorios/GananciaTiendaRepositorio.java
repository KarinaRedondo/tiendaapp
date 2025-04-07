package com.tienda.tiendaapp.repositorios;

import com.tienda.tiendaapp.entidades.GananciaTienda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GananciaTiendaRepositorio extends MongoRepository<GananciaTienda, String> {
    GananciaTienda findByIdTienda(String idTienda);

    List<GananciaTienda> findByIdTiendaAndFechaVentaBetween(
            String idTienda,
            String fechaInicio,
            String fechaFin
    );
}
