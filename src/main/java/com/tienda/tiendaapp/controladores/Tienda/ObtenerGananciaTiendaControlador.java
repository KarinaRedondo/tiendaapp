package com.tienda.tiendaapp.controladores.Tienda;

import com.tienda.tiendaapp.dtos.ganancias.GananciasResponseDTO;
import com.tienda.tiendaapp.servicios.Tienda.ObtenerGananciasTiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ObtenerGananciaTiendaControlador {

    @Autowired
    private ObtenerGananciasTiendaServicio gananciasServicio;

    @GetMapping("/tiendas/ganancia/{idTienda}")
    public ResponseEntity<?> getGanancias(@PathVariable String idTienda) {
        GananciasResponseDTO response = gananciasServicio.ejecutar(idTienda);
        return ResponseEntity.ok(response);
    }
}
