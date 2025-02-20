package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "calificaciones")

public class Calificacion {

    @Id
    private String idCalificacion;
    private int calificacionDomiciliario;
    private int calificacionPedido;
    private String comentarios;
    private String fecha;

    public int getCalificacionDomiciliario() {
        return calificacionDomiciliario;
    }

    public void setCalificacionDomiciliario(int calificacionDomiciliario) {
        this.calificacionDomiciliario = calificacionDomiciliario;
    }

    public int getCalificacionPedido() {
        return calificacionPedido;
    }

    public void setCalificacionPedido(int calificacionPedido) {
        this.calificacionPedido = calificacionPedido;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
