package com.asterik.client.client.controller;

import com.asterik.client.client.dto.AllProductDTO;
import com.asterik.client.client.dto.ProductResposneDTO;
import com.asterik.client.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("findproduct")
    public AllProductDTO findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("findproduct/{id}")
    public ProductResposneDTO findProductById(@PathVariable("id") int id){
        return productService.findProductById(id);
    }
}
