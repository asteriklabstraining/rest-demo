package com.asterik.client.client.service;

import com.asterik.client.client.config.WebClientConfig;
import com.asterik.client.client.dto.AllProductDTO;
import com.asterik.client.client.dto.ProductResposneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WebFluxExampleImpl implements WebFluxExample{
    @Autowired
    private WebClientConfig webClientConfig;


    @Override
    public AllProductDTO findAllProducts() {
        return null;
    }

    @Override
    public ProductResposneDTO findProduct(int id) {
        String url = "https://dummyjson.com/fdsf"+id;

        ProductResposneDTO productResposneDTO = webClientConfig.webClient()
                .get()
                .uri(url)
                .retrieve()
                .onStatus(
                        HttpStatus::is2xxSuccessful,
                        clientResponse -> {
                            System.out.println("200 response received from server");
                            return Mono.empty();
                        }
                ).onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse -> {
                            System.out.println("400 error received from server, errorCode: "+clientResponse.statusCode());
                            return Mono.empty();
                        }
                ).onStatus(HttpStatus::is5xxServerError,
                        clientResponse -> {
                            System.out.println("500 error received from server, errorCode: "+clientResponse.statusCode());
                            return Mono.empty();
                        })
                .bodyToMono(ProductResposneDTO.class).block();
        return productResposneDTO;
    }
}
