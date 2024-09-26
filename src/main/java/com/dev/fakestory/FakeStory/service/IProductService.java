package com.dev.fakestory.FakeStory.service;

import com.dev.fakestory.FakeStory.FakeStoryDTO.FakeStoryProductResponse;

import java.util.List;

public interface IProductService
{
    public List<FakeStoryProductResponse> getAllProducts();

    public FakeStoryProductResponse getProductById(Long id);
}
