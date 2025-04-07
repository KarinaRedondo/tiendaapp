package com.tienda.tiendaapp.servicios.Tienda;

import com.tienda.tiendaapp.dtos.ganancias.GananciasResponseDTO;
import com.tienda.tiendaapp.entidades.GananciaDomiciliario;
import com.tienda.tiendaapp.repositorios.GananciaDomiciliarioRepositorio;
import com.tienda.tiendaapp.utils.FechaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerGananciasDomiciliarioServicio {

    private final GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio;

    @Autowired
    public ObtenerGananciasDomiciliarioServicio(GananciaDomiciliarioRepositorio gananciaDomiciliarioRepositorio) {
        this.gananciaDomiciliarioRepositorio = gananciaDomiciliarioRepositorio;
    }

    public GananciasResponseDTO ejecutar(String idDomiciliario) {
        // Ganancias semanales
        FechaUtils.RangoFechas rangoSemanal = FechaUtils.obtenerRangoSemanal();
        List<GananciaDomiciliario> gananciasSemanales = gananciaDomiciliarioRepositorio
                .findByIdDomiciliarioAndFechaVentaBetween(
                        idDomiciliario,
                        rangoSemanal.getFechaInicio(),
                        rangoSemanal.getFechaFin()
                );
        double totalSemanal = gananciasSemanales.stream()
                .mapToDouble(GananciaDomiciliario::getMonto)
                .sum();

        // Ganancias mensuales
        FechaUtils.RangoFechas rangoMensual = FechaUtils.obtenerRangoMensual();
        List<GananciaDomiciliario> gananciasMensuales = gananciaDomiciliarioRepositorio
                .findByIdDomiciliarioAndFechaVentaBetween(
                        idDomiciliario,
                        rangoMensual.getFechaInicio(),
                        rangoMensual.getFechaFin()
                );
        double totalMensual = gananciasMensuales.stream()
                .mapToDouble(GananciaDomiciliario::getMonto)
                .sum();

        // Ganancias anuales
        FechaUtils.RangoFechas rangoAnual = FechaUtils.obtenerRangoAnual();
        List<GananciaDomiciliario> gananciasAnuales = gananciaDomiciliarioRepositorio
                .findByIdDomiciliarioAndFechaVentaBetween(
                        idDomiciliario,
                        rangoAnual.getFechaInicio(),
                        rangoAnual.getFechaFin()
                );
        double totalAnual = gananciasAnuales.stream()
                .mapToDouble(GananciaDomiciliario::getMonto)
                .sum();

        // Ganancias diarias
        FechaUtils.RangoFechas rangoDiario = FechaUtils.obtenerRangoDiario();
        List<GananciaDomiciliario> gananciasDiarias = gananciaDomiciliarioRepositorio
                .findByIdDomiciliarioAndFechaVentaBetween(
                        idDomiciliario,
                        rangoDiario.getFechaInicio(),
                        rangoDiario.getFechaFin()
                );
        double totalDiario = gananciasDiarias.stream()
                .mapToDouble(GananciaDomiciliario::getMonto)
                .sum();

        return new GananciasResponseDTO(totalDiario, totalSemanal, totalMensual);
    }
}

