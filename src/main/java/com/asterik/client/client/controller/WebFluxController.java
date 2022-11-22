package com.asterik.client.client.controller;

import com.asterik.client.client.dto.ProductResposneDTO;
import com.asterik.client.client.service.WebFluxExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebFluxController {
    @Autowired
    private WebFluxExample webFluxExample;

    @GetMapping("/webflux/{id}")
    public ProductResposneDTO findProductById(@PathVariable("id") int id){
        return webFluxExample.findProduct(id);
    }
}
