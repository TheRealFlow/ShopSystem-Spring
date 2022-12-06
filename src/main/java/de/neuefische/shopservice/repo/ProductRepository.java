package de.neuefische.shopservice.repo;

import de.neuefische.shopservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "Apfel", 1.3),
                    new Product(2, "Banane", 1.5),
                    new Product(3, "Zitrone", 1.7),
                    new Product(4, "Mandarine", 1.9)
            )
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        Product product = null;

        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }

        return product;
    }
}
