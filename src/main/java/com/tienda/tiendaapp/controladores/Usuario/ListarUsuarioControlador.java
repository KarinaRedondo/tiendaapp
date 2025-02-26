package com.tienda.tiendaapp.controladores.Usuario;

import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.servicios.Usuario.ListarUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")

public class ListarUsuarioControlador {

    private final ListarUsuarioServicio listarUsuarioServicio;

    @Autowired
    public  ListarUsuarioControlador(ListarUsuarioServicio listarUsuarioServicio) {
        this.listarUsuarioServicio = listarUsuarioServicio;
    }

    @GetMapping(value = "/listar", headers = "Accept=application/json")
    public ResponseEntity<?> listarUsuarioControlador() {

        try {
            List<Usuario> listaUsuarioRetornada = listarUsuarioServicio.listarUsuarios();
            return new ResponseEntity<>(listaUsuarioRetornada, HttpStatus.OK);
        }
        catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de obtener los usuarios"+ exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
