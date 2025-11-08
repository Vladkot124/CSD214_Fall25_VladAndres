package csd214_fall2025.pojos;

import csd214_fall2025.entites.MagazineEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class MySQLMagazineRepository implements ProductRepository<MagazineEntity> {
    private final EntityManager em;

    public MySQLMagazineRepository(EntityManager em) { this.em = em; }

    public void add(MagazineEntity item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void update(MagazineEntity item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        MagazineEntity entity = em.find(MagazineEntity.class, id);
        if (entity != null) em.remove(entity);
        em.getTransaction().commit();
    }

    public List<MagazineEntity> getAll() {
        return em.createQuery("SELECT m FROM MagazineEntity m", MagazineEntity.class).getResultList();
    }

    public MagazineEntity getById(Long id) { return em.find(MagazineEntity.class, id); }
}
