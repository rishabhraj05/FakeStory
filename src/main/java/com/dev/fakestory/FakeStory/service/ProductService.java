package com.dev.fakestory.FakeStory.service;

import com.dev.fakestory.FakeStory.FakeStoryDTO.FakeStoryProductRequest;
import com.dev.fakestory.FakeStory.FakeStoryDTO.FakeStoryProductResponse;
import com.dev.fakestory.FakeStory.mapper.FakeStoryToProductModel;
import com.dev.fakestory.FakeStory.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements IProductService
{
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<FakeStoryProductResponse> getAllProducts()
    {
        FakeStoryProductResponse[] p =
                restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoryProductResponse[].class).getBody();

        ArrayList<Product> products = FakeStoryToProductModel.toListOfProducts(p);
        return Arrays.asList(Objects.requireNonNull(p));

    }

    @Override
    public FakeStoryProductResponse getProductById(Long id)
    {
        ResponseEntity<FakeStoryProductResponse> productResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoryProductResponse.class, id);

        return productResponse.getBody();
    }

    public ResponseEntity<FakeStoryProductRequest> addProduct(FakeStoryProductRequest productRequest)
    {
        return restTemplate.
                postForEntity("https://fakestoreapi.com/products/", productRequest, FakeStoryProductRequest.class);

    }
}
