package csd214_fall2025.pojos;

import java.util.List;

public class ProductService<T> {

    private final ProductRepository<T> repository;

    public ProductService(ProductRepository<T> repository) {
        this.repository = repository;
    }

    public void add(T item) { repository.add(item); }
    public void update(T item) { repository.update(item); }
    public void delete(Long id) { repository.delete(id); }
    public List<T> getAll() { return repository.getAll(); }
    public T getById(Long id) { return repository.getById(id); }
}
