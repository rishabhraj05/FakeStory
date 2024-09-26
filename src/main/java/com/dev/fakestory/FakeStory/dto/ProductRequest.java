package com.dev.fakestory.FakeStory.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest
{
    String title, description, category, image;
    double price;
    int amount;
}
