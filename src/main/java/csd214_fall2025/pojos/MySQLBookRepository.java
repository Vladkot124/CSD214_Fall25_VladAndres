package csd214_fall2025.pojos;

import csd214_fall2025.entites.BookEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class MySQLBookRepository implements ProductRepository<BookEntity> {

    private final EntityManager em;

    public MySQLBookRepository(EntityManager em) {
        this.em = em;
    }

    public void add(BookEntity book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public void update(BookEntity book) {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        BookEntity book = em.find(BookEntity.class, id);
        if (book != null) em.remove(book);
        em.getTransaction().commit();
    }

    public List<BookEntity> getAll() {
        return em.createQuery("SELECT b FROM BookEntity b", BookEntity.class).getResultList();
    }

    public BookEntity getById(Long id) {
        return em.find(BookEntity.class, id);
    }
}
