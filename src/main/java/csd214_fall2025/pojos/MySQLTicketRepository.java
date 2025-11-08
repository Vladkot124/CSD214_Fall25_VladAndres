package csd214_fall2025.pojos;

import csd214_fall2025.entites.TicketEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class MySQLTicketRepository implements ProductRepository<TicketEntity> {
    private final EntityManager em;

    public MySQLTicketRepository(EntityManager em) { this.em = em; }

    public void add(TicketEntity item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void update(TicketEntity item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        TicketEntity entity = em.find(TicketEntity.class, id);
        if (entity != null) em.remove(entity);
        em.getTransaction().commit();
    }

    public List<TicketEntity> getAll() {
        return em.createQuery("SELECT t FROM TicketEntity t", TicketEntity.class).getResultList();
    }

    public TicketEntity getById(Long id) { return em.find(TicketEntity.class, id); }
}
