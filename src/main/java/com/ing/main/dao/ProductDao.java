package com.ing.main.dao;

import com.ing.main.db.Product;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public Product getProductById(int id) {
        try {
            TypedQuery<Product> getByIdQuery = em.createNamedQuery("Product.findById", Product.class);
            getByIdQuery.setParameter("id", id);
            return getByIdQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsByPrice(int price) {
        try {
            TypedQuery<Product> getByPriceQuery = em.createNamedQuery("Product.findByPrice", Product.class);
            getByPriceQuery.setParameter("price", price);
            return getByPriceQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<Product> getProductsByName(String name) {
        try {
            TypedQuery<Product> getByNameQuery = em.createNamedQuery("Product.findByName", Product.class);
            getByNameQuery.setParameter("name", name);
            return getByNameQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<Product> getProductsByNamePrice(String name, int price) {
        try {
            TypedQuery<Product> getByNamePriceQuery = em.createNamedQuery("Product.findByNamePrice", Product.class);
            getByNamePriceQuery.setParameter("name", name);
            getByNamePriceQuery.setParameter("price", price);
            return getByNamePriceQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<Product> getAllProducts() {
        try {
            TypedQuery<Product> getAllQuery = em.createNamedQuery("Product.findAll", Product.class);
            return getAllQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public boolean changePrice(Product p, int newPrice) {
        try {
            TypedQuery<Product> changePriceQuery = em.createNamedQuery("Product.findByNamePrice", Product.class);
            changePriceQuery.setParameter("name", p.getName());
            changePriceQuery.setParameter("price", p.getPrice());
            Product ctxProduct = (Product) changePriceQuery.getSingleResult();
            ctxProduct.setPrice(newPrice);
            em.persist(ctxProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeName(Product p, String newName) {
        try {
            TypedQuery<Product> changeNameQuery = em.createNamedQuery("Product.findByNamePrice", Product.class);
            changeNameQuery.setParameter("name", p.getName());
            changeNameQuery.setParameter("price", p.getPrice());
            Product ctxProdus = (Product) changeNameQuery.getSingleResult();
            ctxProdus.setName(newName);
            em.persist(ctxProdus);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeNamePrice(Product p, int newPrice, String newName) {
        try {
            TypedQuery<Product> changeNamePriceQuery = em.createNamedQuery("Product.findByNamePrice", Product.class);
            changeNamePriceQuery.setParameter("name", p.getName());
            changeNamePriceQuery.setParameter("price", p.getPrice());
            Product ctxProduct = (Product) changeNamePriceQuery.getSingleResult();
            ctxProduct.setName(newName);
            ctxProduct.setPrice(newPrice);
            em.persist(ctxProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(Product p) {
        try {
            TypedQuery<Product> deleteProductQuery = em.createNamedQuery("Product.findByNamePrice", Product.class);
            deleteProductQuery.setParameter("name", p.getName());
            deleteProductQuery.setParameter("price", p.getPrice());
            Product ctxProdus = (Product) deleteProductQuery.getSingleResult();
            em.remove(ctxProdus);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
