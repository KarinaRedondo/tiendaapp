package com.tienda.tiendaapp.servicios.Tienda;

import java.util.List;
import com.tienda.tiendaapp.dtos.ganancias.GananciasResponseDTO;
import com.tienda.tiendaapp.entidades.GananciaTienda;
import com.tienda.tiendaapp.repositorios.GananciaTiendaRepositorio;
import com.tienda.tiendaapp.utils.FechaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtenerGananciasTiendaServicio {

    private final GananciaTiendaRepositorio gananciaTiendaRepositorio;

    @Autowired
    public ObtenerGananciasTiendaServicio(GananciaTiendaRepositorio gananciaTiendaRepositorio) {
        this.gananciaTiendaRepositorio = gananciaTiendaRepositorio;
    }

    public GananciasResponseDTO ejecutar(String idTienda) {
        // Calcular ganancias semanales
        FechaUtils.RangoFechas rangoSemanal = FechaUtils.obtenerRangoSemanal();
        List<GananciaTienda> gananciasSemanales = gananciaTiendaRepositorio
                .findByIdTiendaAndFechaVentaBetween(
                        idTienda,
                        rangoSemanal.getFechaInicio(),
                        rangoSemanal.getFechaFin()
                );

        double totalSemanal = gananciasSemanales.stream()
                .mapToDouble(GananciaTienda::getMonto)
                .sum();

        // Calcular ganancias mensuales
        FechaUtils.RangoFechas rangoMensual = FechaUtils.obtenerRangoMensual();
        List<GananciaTienda> gananciasMensuales = gananciaTiendaRepositorio
                .findByIdTiendaAndFechaVentaBetween(
                        idTienda,
                        rangoMensual.getFechaInicio(),
                        rangoMensual.getFechaFin()
                );

        double totalMensual = gananciasMensuales.stream()
                .mapToDouble(GananciaTienda::getMonto)
                .sum();

        // Crear y retornar el DTO de respuesta
        return new GananciasResponseDTO(totalSemanal, totalMensual);
    }
}