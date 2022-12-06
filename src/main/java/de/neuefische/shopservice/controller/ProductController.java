package de.neuefische.shopservice.controller;

import de.neuefische.shopservice.model.Product;
import de.neuefische.shopservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ShopService shopService;

    @GetMapping
    public List<Product> getProducts () {
        return shopService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById (@PathVariable int id) {
        return shopService.getProductById(id);
    }
}
