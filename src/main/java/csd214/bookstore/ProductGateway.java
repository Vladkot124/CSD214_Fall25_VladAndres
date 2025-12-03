package csd214.bookstore;

import csd214.bookstore.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {
    ProductEntity save(ProductEntity product);
    Optional<ProductEntity> findById(long id);
    List<ProductEntity> findAll();
    void deleteById(long id);
    void close();
}
