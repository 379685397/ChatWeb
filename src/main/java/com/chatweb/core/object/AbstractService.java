package com.chatweb.core.object;

import java.util.List;

public interface AbstractService<T, Id> {

    T save(T entity);

    void delete(Id id);

    T update(T entity);

    T getById(Id id);

    default List<T> findAll(){
        return null;
    };
}
