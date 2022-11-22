package com.asterik.client.client.service;

import com.asterik.client.client.dto.AllProductDTO;
import com.asterik.client.client.dto.ProductResposneDTO;

public interface WebFluxExample {
    AllProductDTO findAllProducts();
    ProductResposneDTO findProduct(int id);
}
