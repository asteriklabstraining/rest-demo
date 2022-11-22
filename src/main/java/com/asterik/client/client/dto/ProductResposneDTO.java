package com.asterik.client.client.dto;

import lombok.Data;

@Data
public class ProductResposneDTO {
    private int id;
    private String title;
    private String description;
    private int price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
}
