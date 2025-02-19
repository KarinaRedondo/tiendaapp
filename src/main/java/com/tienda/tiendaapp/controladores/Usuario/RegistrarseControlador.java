package com.tienda.tiendaapp.controladores.Usuario;
import com.tienda.tiendaapp.dtos.RegistrarseDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.servicios.Usuario.RegistrarseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class RegistrarseControlador {

    private RegistrarseServicio registrarseServicio;

    @Autowired

    public RegistrarseControlador(RegistrarseServicio registrarseServicio) {
        this.registrarseServicio = registrarseServicio;
    }

@PostMapping(value = "/crear-usuario", headers = "Accept=application/json")
    public ResponseEntity<?> registrarseControlador(@RequestBody RegistrarseDto registrarseDto) {

    try {
        System.out.println("Datos recibidos: " + registrarseDto.toString());
        Usuario usuarioCreado = registrarseServicio.crearUsuario(registrarseDto);
        return new ResponseEntity<>(usuarioCreado, HttpStatus.OK);
    } catch (Exception exception) {
        String mensajeDeError = "Hubo un error al tratar de crear el usuario" + exception.getMessage();
        return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}
