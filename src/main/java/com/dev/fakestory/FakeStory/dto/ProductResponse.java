package com.dev.fakestory.FakeStory.dto;

import lombok.Data;

@Data
public class ProductResponse
{
    double price;
    String id, title, description, category, image;
    Rating rating;
}
