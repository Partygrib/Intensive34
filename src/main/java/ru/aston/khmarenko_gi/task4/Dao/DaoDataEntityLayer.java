package ru.aston.khmarenko_gi.task4.Dao;

import java.util.List;

public interface DaoDataEntityLayer<T> {
    List<T> findAll();
    T findEntityById(long id);
    boolean delete(long id);
    boolean create(T t);
    T update(T t);
}
