package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.dtos.ganancias.GananciasResponseDTO;
import com.tienda.tiendaapp.servicios.Tienda.ObtenerGananciasDomiciliarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ObtenerGananciaDomiciliarioControlador {

    @Autowired
    private ObtenerGananciasDomiciliarioServicio gananciasServicio;

    @GetMapping("/domiciliarios/ganancia/{idDomiciliario}")
    public ResponseEntity<?> getGanancias(@PathVariable String idDomiciliario) {
        GananciasResponseDTO response = gananciasServicio.ejecutar(idDomiciliario);
        return ResponseEntity.ok(response);
    }
}

