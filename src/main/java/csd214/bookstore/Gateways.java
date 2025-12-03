package csd214.bookstore;

import csd214.bookstore.entities.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Gateways {

    public static ProductGateway create(PersistenceMode mode) {
        return switch (mode) {
            case IN_MEMORY -> new InMemoryGateway();
            case H2_JPA -> new JpaGateway("h2PU");
            case MYSQL_JPA -> new JpaGateway("mysqlPU");
        };
    }

    // -------- In-Memory --------
    private static class InMemoryGateway implements ProductGateway {
        private final Map<Long, ProductEntity> store = new LinkedHashMap<>();
        private final AtomicLong seq = new AtomicLong(1);

        @Override
        public ProductEntity save(ProductEntity product) {
            if (product.getId() == null) product.setId(seq.getAndIncrement());
            store.put(product.getId(), product);
            return product;
        }

        @Override
        public Optional<ProductEntity> findById(long id) {
            return Optional.ofNullable(store.get(id));
        }

        @Override
        public List<ProductEntity> findAll() {
            return new ArrayList<>(store.values());
        }

        @Override
        public void deleteById(long id) {
            store.remove(id);
        }

        @Override
        public void close() { }
    }

    // -------- JPA (H2 or MySQL depending on persistence unit) --------
    private static class JpaGateway implements ProductGateway {
        private final EntityManagerFactory emf;

        JpaGateway(String pu) {
            this.emf = Persistence.createEntityManagerFactory(pu);
        }

        @Override
        public ProductEntity save(ProductEntity product) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                ProductEntity merged = em.merge(product);
                em.getTransaction().commit();
                return merged;
            } finally {
                em.close();
            }
        }

        @Override
        public Optional<ProductEntity> findById(long id) {
            EntityManager em = emf.createEntityManager();
            try {
                return Optional.ofNullable(em.find(ProductEntity.class, id));
            } finally {
                em.close();
            }
        }

        @Override
        public List<ProductEntity> findAll() {
            EntityManager em = emf.createEntityManager();
            try {
                return em.createQuery("select p from ProductEntity p", ProductEntity.class).getResultList();
            } finally {
                em.close();
            }
        }

        @Override
        public void deleteById(long id) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                ProductEntity found = em.find(ProductEntity.class, id);
                if (found != null) em.remove(found);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }

        @Override
        public void close() {
            emf.close();
        }
    }
}
