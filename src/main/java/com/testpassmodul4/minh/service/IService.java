package com.testpassmodul4.minh.service;

public interface IService<T> {
    Iterable<T> findAll();

    T findById(Integer id) ;

    void save(T model);

    void remove(Integer id);
}
