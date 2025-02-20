package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tenderos")

public class Tendero extends Usuario {

    private String nombreDeLaTienda;
    private String direccionTienda;
    private String telefonoTienda;
    private String[] historialPedidosAtendidos;

    public String getNombreDeLaTienda() {
        return nombreDeLaTienda;
    }

    public void setNombreDeLaTienda(String nombreDeLaTienda) {
        this.nombreDeLaTienda = nombreDeLaTienda;
    }

    public String getDireccionTienda() {
        return direccionTienda;
    }

    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }

    public String getTelefonoTienda() {
        return telefonoTienda;
    }

    public void setTelefonoTienda(String telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    public String[] getHistorialPedidosAtendidos() {
        return historialPedidosAtendidos;
    }

    public void setHistorialPedidosAtendidos(String[] historialPedidosAtendidos) {
        this.historialPedidosAtendidos = historialPedidosAtendidos;
    }
}
