package com.dev.fakestory.FakeStory.FakeStoryDTO;

import lombok.Data;

@Data
public class FakeStoryProductRequest implements FakeStory {
    String title, description, category, image;
    double price;
}
