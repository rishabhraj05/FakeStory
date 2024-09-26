package com.dev.fakestory.FakeStory.Controller;

import com.dev.fakestory.FakeStory.FakeStoryDTO.FakeStoryProductRequest;
import com.dev.fakestory.FakeStory.FakeStoryDTO.FakeStoryProductResponse;
import com.dev.fakestory.FakeStory.dto.ProductRequest;
import com.dev.fakestory.FakeStory.dto.ProductResponse;
import com.dev.fakestory.FakeStory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController
{
    private ProductService productService;

    @Autowired
    ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<FakeStoryProductResponse>> getAllProducts()
    {
        List<FakeStoryProductResponse> productResponses =
                productService.getAllProducts();

        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<FakeStoryProductResponse> getProductById(@PathVariable("productId") Long id)
    {
        FakeStoryProductResponse product = productService.getProductById(id);
        ResponseEntity<FakeStoryProductResponse> response;

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("class", "Product");
        headers.add("class", "Product1");
        headers.add("class", "Product2");

        if(Objects.isNull(product))
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            response = new ResponseEntity<>(product, headers, HttpStatus.OK);

        try
        {
            throw new Exception("Not Working");
        }
        catch (Exception e)
        {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<FakeStoryProductRequest> addProduct(@RequestBody FakeStoryProductRequest productRequest)
    {
       return productService.addProduct(productRequest);
    }
}