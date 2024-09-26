package com.dev.fakestory.FakeStory.FakeStoryDTO;

import com.dev.fakestory.FakeStory.dto.Rating;
import lombok.Data;

@Data
public class FakeStoryProductResponse implements FakeStory
{
    double price;
    String id, title, description, category, image;
    Rating rating;
}
