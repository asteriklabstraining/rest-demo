package com.asterik.client.client.service;

import com.asterik.client.client.dto.AllProductDTO;
import com.asterik.client.client.dto.ProductResposneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AllProductDTO findAllProducts() {
     String url = "https://dummyjson.com/products";
     AllProductDTO allProductDTO = restTemplate.getForObject(url, AllProductDTO.class);
     return allProductDTO;
    }

    @Override
    public ProductResposneDTO findProductById(int id) {
        String url = "https://dummyjson.com/products/"+id;
        ProductResposneDTO productResposneDTO = restTemplate.getForObject(url, ProductResposneDTO.class);
        return productResposneDTO;
    }
}
