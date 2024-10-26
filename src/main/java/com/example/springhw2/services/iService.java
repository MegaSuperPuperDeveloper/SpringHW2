package com.example.springhw2.services;

import java.util.List;

public interface iService<T> {
    List<T> getAll();
    void add(T t);
    T get(long id);
    List<T> get(String name);
    void delete(long id);
}