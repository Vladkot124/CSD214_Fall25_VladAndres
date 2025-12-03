package csd214.bookstore;

import csd214.bookstore.entities.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Lab3Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            BookEntity b = new BookEntity();
            b.setTitle("Lab3 Book");
            b.setAuthor("Vladyslav Andres");
            b.setCopies(5);
            b.setPrice(19.99);
            b.setIsbn10("1234567890");
            b.setDescription("Book entity");
            em.persist(b);

            MagazineEntity m = new MagazineEntity();
            m.setTitle("Lab3 Magazine");
            m.setCopies(10);
            m.setPrice(9.99);
            m.setIsbn10("0987654321");
            m.setDescription("Magazine entity");
            m.setOrderQty(10);
            m.setCurrentIssue(LocalDate.now());
            em.persist(m);

            TicketEntity t = new TicketEntity();
            t.setPrice(49.99);
            t.setDescription("Ticket entity");
            em.persist(t);

            em.getTransaction().commit();

            System.out.println("Saved Book id=" + b.getId());
            System.out.println("Saved Magazine id=" + m.getId());
            System.out.println("Saved Ticket id=" + t.getId());

            List<ProductEntity> all = em.createQuery("select p from ProductEntity p", ProductEntity.class).getResultList();
            System.out.println("\nALL PRODUCTS (" + all.size() + ")");
            all.forEach(System.out::println);

            em.getTransaction().begin();
            b.setAuthor(b.getAuthor() + " (edited)");
            em.merge(b);
            em.getTransaction().commit();
            System.out.println("\nUPDATED BOOK: " + b);

            em.getTransaction().begin();
            TicketEntity foundTicket = em.find(TicketEntity.class, t.getId());
            if (foundTicket != null) em.remove(foundTicket);
            em.getTransaction().commit();
            System.out.println("\nDELETED TICKET id=" + t.getId());

        } finally {
            em.close();
            emf.close();
        }
    }
}
