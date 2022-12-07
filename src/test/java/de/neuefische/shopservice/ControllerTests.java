package de.neuefische.shopservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public class ControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void getProduct_shouldReturnAllProduct() throws Exception {
        String expectedJSON = """
                [
                    {
                        "id": 1,
                        "name": "Apfel",
                        "price": 1.3
                    },
                    {
                        "id": 2,
                        "name": "Banane",
                        "price": 1.5
                    },
                    {
                        "id": 3,
                        "name": "Zitrone",
                        "price": 1.7
                    },
                    {
                        "id": 4,
                        "name": "Mandarine",
                        "price": 1.9
                    }
                ]
                """;

        mvc.perform(MockMvcRequestBuilders.get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void getProductById_shouldReturnASingleProduct() throws Exception {
        String expectedJSON = """
                    {
                        "id": 1,
                        "name": "Apfel",
                        "price": 1.3
                    }
                """;

        mvc.perform(MockMvcRequestBuilders.get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void getOrder_shouldReturnAllOrders() throws Exception {
        String expectedJSON = """
                [
                    {
                        "id": 1,
                        "products": [
                            {
                                "id": 1,
                                "name": "Apfel",
                                "price": 1.3
                            },
                            {
                                "id": 2,
                                "name": "Banane",
                                "price": 1.5
                            }
                        ]
                    }
                ]
                """;

        mvc.perform(MockMvcRequestBuilders.get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void getOrderById_shouldReturnASingleOrder() throws Exception {
            String expectedJSON = """
                    {
                        "id": 1,
                        "productIds": [
                            1,
                            2
                        ]
                    }
                    """;

        mvc.perform(MockMvcRequestBuilders.get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void postOrder_shouldReturnTheAddedOrder() throws Exception {
            String requestBody = "[1, 2, 3]";

            String expectedJSON = """
                    {
                      "productIds": [
                          1,
                          2,
                          3
                      ]
                    }
                    """;

        mvc.perform(MockMvcRequestBuilders.post("/api/orders/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                        .andExpect(status().isOk())
                        .andExpect(content().json(expectedJSON));
    }
}
