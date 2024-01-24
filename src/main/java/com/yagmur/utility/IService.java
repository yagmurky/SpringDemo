package com.yagmur.utility;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IService <T, ID> {

    T save(T entity);
    T update(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    void deleteById(ID id);
    void delete(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);


}
