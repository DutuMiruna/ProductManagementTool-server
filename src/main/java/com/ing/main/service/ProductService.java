package com.ing.main.service;

import com.ing.main.dao.ProductDao;
import com.ing.main.db.Product;
import com.ing.main.util.GenericMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mirun
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public GenericMessage addProduct(String name, int price) {
        if (productDao.getProductsByNamePrice(name, price).isEmpty()) {
            Product p = new Product();
            p.setName(name);
            p.setPrice(price);

            boolean result = productDao.addProduct(p);
            if (result == true) {
                return new GenericMessage("Product added succesfully.");
            } else {
                return new GenericMessage("Could not add product with name = " + name + " and price = " + price);
            }
        }else{
            return new GenericMessage("The product with name = " + name + " and price = " + price+" already exists in DB."); 
        }
    }

    public Object getProductById(int id) {
        Object object = productDao.getProductById(id);
        if (object != null) {
            Product product = (Product) object;
            return product;
        } else {
            return new GenericMessage("Could not retrieve product with id = " + id);
        }
    }

    public Object getProductsByPrice(int price) {
        List<Product> list = productDao.getProductsByPrice(price);
        if (!list.isEmpty()) {
            return list;
        } else {
            return new GenericMessage("No products found for price = " + price);
        }
    }

    public Object getProductsByName(String name) {
        List<Product> list = productDao.getProductsByName(name);
        if (!list.isEmpty()) {
            return list;
        } else {
            return new GenericMessage("No products found for name = " + name);
        }
    }

    public Object getProductsByNamePrice(String name, int price) {
        List<Product> list = productDao.getProductsByNamePrice(name, price);
        if (!list.isEmpty()) {
            return list;
        } else {
            return new GenericMessage("No products found for name = " + name + " and price = " + price);
        }
    }

    public Object getAllProducts() {
        List<Product> list = productDao.getAllProducts();
        if (!list.isEmpty()) {
            return list;
        } else {
            return new GenericMessage("No products found. ");
        }
    }

    @Transactional
    public GenericMessage changePrice(String name, int oldPrice, int newPrice) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(oldPrice);
        boolean result = productDao.changePrice(p, newPrice);
        if (result == true) {
            return new GenericMessage("Product changed succesfully.");
        } else {
            return new GenericMessage("Could not change pret for product with name = " + name + " and price = " + oldPrice);
        }
    }

    @Transactional
    public GenericMessage changeName(int price, String oldName, String newName) {
        Product p = new Product();
        p.setName(oldName);
        p.setPrice(price);
        boolean result = productDao.changeName(p, newName);
        if (result == true) {
            return new GenericMessage("Product changed succesfully.");
        } else {
            return new GenericMessage("Could not change name for product with nume = " + oldName + " and pret = " + price);
        }

    }

    @Transactional
    public GenericMessage changeNamePrice(int oldPrice, int newPrice, String oldName, String newName) {
        Product p = new Product();
        p.setName(oldName);
        p.setPrice(oldPrice);
        boolean result = productDao.changeNamePrice(p, newPrice, newName);
        if (result == true) {
            return new GenericMessage("Product changed succesfully.");
        } else {
            return new GenericMessage("Could not change name and pret for product with name = " + oldName + " and price = " + oldPrice);
        }
    }

    @Transactional
    public GenericMessage deleteProduct(String name, int price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        boolean result = productDao.deleteProduct(p);
        if (result == true) {
            return new GenericMessage("Product deleted succesfully.");
        } else {
            return new GenericMessage("Could not delete product with name = " + name + " and price = " + price);
        }
    }

    @Transactional
    public GenericMessage deleteProductById(int id) {
        boolean result = productDao.deleteProductById(id);
        if (result == true) {
            return new GenericMessage("Product deleted succesfully.");
        } else {
            return new GenericMessage("Could not delete product with id = " + id + ".");
        }
    }
}
