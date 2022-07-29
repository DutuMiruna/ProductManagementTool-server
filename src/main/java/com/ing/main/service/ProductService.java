package com.ing.main.service;

import com.ing.main.dao.ProductDao;
import com.ing.main.db.Product;
import com.ing.main.util.GenericMessage;
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
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        boolean result = productDao.addProduct(p);
        if (result == true) {
            return new GenericMessage("Product added succesfully.");
        } else {
            return new GenericMessage("Could not add product with name = " + name + " and price = " + price);
        }
    }
}
