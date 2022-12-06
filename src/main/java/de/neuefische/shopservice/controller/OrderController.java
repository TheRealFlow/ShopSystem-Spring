package de.neuefische.shopservice.controller;

import de.neuefische.shopservice.model.Order;
import de.neuefische.shopservice.model.OrderResponse;
import de.neuefische.shopservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ShopService shopService;

    @GetMapping
    public List<OrderResponse> getOrders () {
        return shopService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById (@PathVariable int id) {
        return shopService.getOrderById(id);
    }

    @PostMapping("/{id}")
    public Order postOrder (@PathVariable int id, @RequestBody List<Integer> productIds) {
        return shopService.createOrder(id, productIds);
    }
}
