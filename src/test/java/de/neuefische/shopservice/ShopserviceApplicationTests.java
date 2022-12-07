package de.neuefische.shopservice;

import de.neuefische.shopservice.model.Product;
import de.neuefische.shopservice.repo.OrderRepository;
import de.neuefische.shopservice.repo.ProductRepository;
import de.neuefische.shopservice.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class ShopserviceApplicationTests {

    ProductRepository productRepo = mock(ProductRepository.class);
    OrderRepository orderRepo = mock(OrderRepository.class);
    ShopService service = new ShopService(productRepo, orderRepo);

    @Test
    void getProductTest() {
        Product product = new Product(1, "Apfel", 1.3);
        List<Product> product1 = new ArrayList<>(List.of(product));
        when(productRepo.getProducts()).thenReturn(product1);

        List<Product> actual = service.getProducts();

        Assertions.assertEquals(List.of(product), actual);
        verify(productRepo).getProducts();
    }
}
