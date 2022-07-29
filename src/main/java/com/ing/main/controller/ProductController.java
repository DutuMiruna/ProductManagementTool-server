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

}
