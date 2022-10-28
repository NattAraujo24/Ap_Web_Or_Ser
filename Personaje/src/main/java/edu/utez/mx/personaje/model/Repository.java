package edu.utez.mx.personaje.model;

import edu.utez.mx.personaje.utils.Response;
import java.util.List;

public interface Repository <T>{
    List<T> findAll();

    Response <T>  findById(Long id);

    Response<BeanPersonaje> save(BeanPersonaje object);

    Response <T> update(T object);
}
