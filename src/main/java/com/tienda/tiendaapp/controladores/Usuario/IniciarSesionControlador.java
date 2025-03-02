package com.tienda.tiendaapp.controladores.Usuario;

import com.tienda.tiendaapp.dtos.usuario.IniciarSesionDto;
import com.tienda.tiendaapp.entidades.Usuario;
import com.tienda.tiendaapp.seguridad.JwtGenerador;
import com.tienda.tiendaapp.servicios.Usuario.IniciarSesionServicio;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usuarios")
public class IniciarSesionControlador {

    private static final Logger logger = LoggerFactory.getLogger(IniciarSesionControlador.class);

    private final IniciarSesionServicio iniciarSesionServicio;
    private final JwtGenerador jwtGenerador;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public IniciarSesionControlador(IniciarSesionServicio iniciarSesionServicio, JwtGenerador jwtGenerador, AuthenticationManager authenticationManager) {
        this.iniciarSesionServicio = iniciarSesionServicio;
        this.jwtGenerador = jwtGenerador;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/iniciar-sesion", headers = "Accept=application/json")
    public ResponseEntity<?> iniciarSesionControlador(@RequestBody IniciarSesionDto iniciarSesionDto) {
        try {
            // Autenticamos al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(iniciarSesionDto.getCorreo(), iniciarSesionDto.getContraseña())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerador.generarToken(authentication);

            // Obtenemos el usuario autenticado
            Usuario usuarioLogueado = (Usuario) authentication.getPrincipal();

            // Creamos la respuesta con el usuario y el token
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("usuario", usuarioLogueado);
            respuesta.put("token", token);

            logger.info("Usuario autenticado exitosamente: {}", usuarioLogueado.getCorreo());
            return ResponseEntity.ok(respuesta);
        } catch (Exception exception) {
            logger.error("Error al intentar iniciar sesión: {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}

