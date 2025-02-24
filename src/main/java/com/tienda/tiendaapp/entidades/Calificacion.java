package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "calificaciones")

public class Calificacion {

    @Id
    private String id;
    private String idpedido;
    private String idCliente;
    private String idTienda;
    private int calificacionTienda;
    private String comentarioTienda;
    private String respuestaTendero;
    private String idDomiciliario;
    private int calificacionDomiciliario;
    private String comentarioDomiciliario;
    private String respuestaDomiciliario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPedido() {
        return idpedido;
    }

    public void setIdPedido(String idpedido) {
        this.idpedido = idpedido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public int getCalificacionTienda() {
        return calificacionTienda;
    }

    public void setCalificacionTienda(int calificacionTienda) {
        this.calificacionTienda = calificacionTienda;
    }

    public String getComentarioTienda() {
        return comentarioTienda;
    }

    public void setComentarioTienda(String comentarioTienda) {
        this.comentarioTienda = comentarioTienda;
    }

    public String getRespuestaTendero() {
        return respuestaTendero;
    }

    public void setRespuestaTendero(String respuestaTendero) {
        this.respuestaTendero = respuestaTendero;
    }

    public String getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(String idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public int getCalificacionDomiciliario() {
        return calificacionDomiciliario;
    }

    public void setCalificacionDomiciliario(int calificacionDomiciliario) {
        this.calificacionDomiciliario = calificacionDomiciliario;
    }

    public String getComentarioDomiciliario() {
        return comentarioDomiciliario;
    }

    public void setComentarioDomiciliario(String comentarioDomiciliario) {
        this.comentarioDomiciliario = comentarioDomiciliario;
    }

    public String getRespuestaDomiciliario() {
        return respuestaDomiciliario;
    }

    public void setRespuestaDomiciliario(String respuestaDomiciliario) {
        this.respuestaDomiciliario = respuestaDomiciliario;
    }
}
