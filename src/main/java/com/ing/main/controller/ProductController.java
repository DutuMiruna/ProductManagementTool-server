/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.main.controller;

import com.ing.main.service.ProductService;
import com.ing.main.util.GenericMessage;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirun
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public GenericMessage addProduct(@RequestBody Map<String, String> param) {
        return productService.addProduct(param.get("name"), Integer.parseInt(param.get("price")));
    }

    @GetMapping("/getProductById/{id}")
    public Object getProductById(@PathVariable(value = "id") int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getProductsByPrice/{price}")
    public Object getProductsByPrice(@PathVariable(value = "price") int price) {
        return productService.getProductsByPrice(price);
    }

    @GetMapping("/getProductsByName/{name}")
    public Object getProductsByName(@PathVariable(value = "name") String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/getProductsByNamePrice/{name}/{price}")
    public Object getProductsByNamePrice(@PathVariable(value = "name") String name, @PathVariable(value = "price") int price) {
        return productService.getProductsByNamePrice(name, price);
    }

    @GetMapping("/getAllProducts")
    public Object getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/changePrice")
    public GenericMessage changePrice(@RequestBody Map<String, String> param) {
        return productService.changePrice(param.get("name"), Integer.parseInt(param.get("oldPrice")), Integer.parseInt(param.get("newPrice")));
    }

    @PostMapping("/changeName")
    public GenericMessage changeName(@RequestBody Map<String, String> param) {
        return productService.changeName(Integer.parseInt(param.get("price")), param.get("oldName"), param.get("newName"));
    }

    @PostMapping("/changeNamePrice")
    public GenericMessage changeNamePrice(@RequestBody Map<String, String> param) {
        return productService.changeNamePrice(Integer.parseInt(param.get("oldPrice")), Integer.parseInt(param.get("newPrice")), param.get("oldName"), param.get("newName"));
    }

    @DeleteMapping("/deleteProduct/{name}/{price}")
    public GenericMessage deleteProduct(@PathVariable(value = "name") String name, @PathVariable(value = "price") int price) {
        return productService.deleteProduct(name, price);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public GenericMessage deleteProductById(@PathVariable(value = "id") int id) {
        return productService.deleteProductById(id);
    }

}
