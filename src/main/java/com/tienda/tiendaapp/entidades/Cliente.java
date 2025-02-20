package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clientes")

public class Cliente extends Usuario {

    private String metodoDePagoPreferido;
    private String direccion;
    private String[] historialDePedidos;

    public String getMetodoDePagoPreferido() {
        return metodoDePagoPreferido;
    }

    public void setMetodoDePagoPreferido(String metodoDePagoPreferido) {
        this.metodoDePagoPreferido = metodoDePagoPreferido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String[] getHistorialDePedidos() {
        return historialDePedidos;
    }

    public void setHistorialDePedidos(String[] historialDePedidos) {
        this.historialDePedidos = historialDePedidos;
    }
}
