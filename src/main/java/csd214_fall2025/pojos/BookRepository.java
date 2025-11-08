package csd214_fall2025.pojos;

import java.util.List;

public interface BookRepository<T> {
    void add(T item);
    void update(T item);
    void delete(Long id);
    List<T> getAll();
    T getById(Long id);
}
