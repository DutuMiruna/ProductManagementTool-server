/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.ing.main.ProjConfig;
import com.ing.main.dao.ProductDao;
import com.ing.main.db.Product;
import com.ing.main.service.ProductService;
import com.ing.main.util.GenericMessage;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

/**
 *
 * @author mirun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjConfig.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(classes = {ProductService.class, ProductDao.class}, properties = "spring.main.lazy-initialization=true")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {

    @Autowired
    ProductService productService;

    @Test

    public void test0_AddProduct() {
        GenericMessage genericMessage = (GenericMessage) productService.addProduct("P-1", 100);
        Assert.isTrue(genericMessage.getMessage().equalsIgnoreCase("Product added succesfully."), "Fail.");
    }

    @Test
    public void test1_GetProductById() {
        Assert.isTrue(productService.getProductById(1) instanceof Product, "Fail.");
    }

    @Test
    public void test2_GetProductsByPrice() {
        Assert.isTrue(productService.getProductsByPrice(1) instanceof List, "Fail.");
    }

    @Test
    public void test3_GetProductsByPrice() {
        Assert.isTrue(productService.getProductsByName("P1") instanceof List, "Fail.");
    }

    @Test
    public void test4_GetProductsByNamePrice() {
        Assert.isTrue(productService.getProductsByNamePrice("P1", 1) instanceof List, "Fail.");
    }

    @Test
    public void test5_GetAllProducts() {
        Assert.isTrue(productService.getAllProducts() instanceof List, "Fail.");
    }
    
    @Test
    public void test6_ChangeName() {
        GenericMessage genericMessage = productService.changeName(100, "P-1", "P-2");
        Assert.isTrue(genericMessage.getMessage().equalsIgnoreCase("Product changed succesfully."), "Fail.");

    }

    @Test
    public void test7_ChangePrice() {
        GenericMessage genericMessage = productService.changePrice("P-2", 100, 200);
        Assert.isTrue(genericMessage.getMessage().equalsIgnoreCase("Product changed succesfully."), "Fail.");
    }
    
     @Test
    public void test8_ChangeNamePrice() {
        GenericMessage genericMessage = productService.changeNamePrice(200, 2000,"P-2","P-20");
        Assert.isTrue(genericMessage.getMessage().equalsIgnoreCase("Product changed succesfully."), "Fail.");
    }


    @Test
    public void test9_DeleteProduct() {
        GenericMessage genericMessage = productService.deleteProduct("P-20", 2000);
        Assert.isTrue(genericMessage.getMessage().equalsIgnoreCase("Product deleted succesfully."), "Fail.");
    }
}
