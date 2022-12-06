package de.neuefische.shopservice.service;

import de.neuefische.shopservice.model.Order;
import de.neuefische.shopservice.model.OrderResponse;
import de.neuefische.shopservice.model.Product;
import de.neuefische.shopservice.repo.OrderRepository;
import de.neuefische.shopservice.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<OrderResponse> getOrders() {
        List<Order> orders = orderRepository.getOrders();
        List<OrderResponse> orderResponse = new ArrayList<>();
        for (Order o : orders) {
            List<Product> products = new ArrayList<>();
            for (int id : o.getProductIds()) {
                products.add(productRepository.getProductById(id));
            }
            orderResponse.add(new OrderResponse(o.getId(), products));
        }

        return orderResponse;
    }

    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    public Order createOrder(int id, List<Integer> productIds) {
        return orderRepository.createOrder(id, productIds);
    }
}
