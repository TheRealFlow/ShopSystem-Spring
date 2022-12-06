package de.neuefische.shopservice.repo;

import de.neuefische.shopservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class OrderRepository {
    List<Order> orders = new ArrayList<>(
            List.of(
                    new Order(1, new ArrayList<>(List.of(1, 2)))
            )
    );

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        Order order = null;

        for (Order p : orders) {
            if (p.getId() == id) {
                order = p;
                break;
            }
        }

        return order;
    }

    public Order createOrder(int id, List<Integer> productIds) {
        Order order = new Order(id, productIds);
        orders.add(order);
        return order;
    }
}
