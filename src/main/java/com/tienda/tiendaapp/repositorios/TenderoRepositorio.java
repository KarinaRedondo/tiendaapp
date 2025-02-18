package com.tienda.tiendaapp.repositorios;
import com.tienda.tiendaapp.entidades.Tendero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TenderoRepositorio extends MongoRepository <Tendero, String> {
}
