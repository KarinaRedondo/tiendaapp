package com.tienda.tiendaapp.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class FechaUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static RangoFechas obtenerRangoSemanal() {
        LocalDate hoy = LocalDate.now();
        LocalDate inicioSemana = hoy.with(java.time.DayOfWeek.MONDAY);
        LocalDate finSemana = inicioSemana.plusDays(6);

        return new RangoFechas(
                inicioSemana.format(FORMATTER),
                finSemana.format(FORMATTER)
        );
    }

    public static RangoFechas obtenerRangoMensual() {
        LocalDate hoy = LocalDate.now();
        LocalDate inicioMes = hoy.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate finMes = hoy.with(TemporalAdjusters.lastDayOfMonth());

        return new RangoFechas(
                inicioMes.format(FORMATTER),
                finMes.format(FORMATTER)
        );
    }

    public static class RangoFechas {
        private final String fechaInicio;
        private final String fechaFin;

        public RangoFechas(String fechaInicio, String fechaFin) {
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
        }

        public String getFechaInicio() {
            return fechaInicio;
        }

        public String getFechaFin() {
            return fechaFin;
        }
    }
}