package csd214_fall2025.pojos;

import csd214_fall2025.entites.BookEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class H2BookRepository implements ProductRepository<BookEntity> {
    private final EntityManager em;

    public H2BookRepository(EntityManager em) { this.em = em; }

    public void add(BookEntity item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void update(BookEntity item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        BookEntity entity = em.find(BookEntity.class, id);
        if (entity != null) em.remove(entity);
        em.getTransaction().commit();
    }

    public List<BookEntity> getAll() {
        return em.createQuery("SELECT b FROM BookEntity b", BookEntity.class).getResultList();
    }

    public BookEntity getById(Long id) { return em.find(BookEntity.class, id); }
}
