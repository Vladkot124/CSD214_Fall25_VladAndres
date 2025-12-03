package csd214.bookstore;

import csd214.bookstore.entities.MagazineEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MagazineCrudTest {

    @Test
    void magazine_crud_h2() {
        ProductGateway gw = Gateways.create(PersistenceMode.H2_JPA);

        // CREATE
        MagazineEntity m = new MagazineEntity();
        m.setTitle("Test Mag");
        m.setCopies(3);
        m.setPrice(5.0);
        m.setIsbn10("1111111111");
        m.setDescription("desc");
        m.setOrderQty(3);
        m.setCurrentIssue(LocalDate.now());

        m = (MagazineEntity) gw.save(m);
        assertNotNull(m.getId());

        // READ
        assertFalse(gw.findAll().isEmpty());

        // UPDATE
        m.setOrderQty(99);
        m = (MagazineEntity) gw.save(m);
        assertEquals(99, m.getOrderQty());

        // DELETE
        gw.deleteById(m.getId());
        assertTrue(gw.findById(m.getId()).isEmpty());

        gw.close();
    }
}
