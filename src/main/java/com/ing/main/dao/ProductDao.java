package com.ing.main.dao;

import com.ing.main.db.Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mirun
 */
@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    public boolean addProduct(Product p) {
        try {
            em.persist(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
