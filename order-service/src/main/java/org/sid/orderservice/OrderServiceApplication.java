package org.sid.orderservice;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.entities.ProductItem;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.modal.Costumer;
import org.sid.orderservice.modal.Product;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.repositories.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(OrderRepository orderRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClientService customerRestClientService,
                            InventoryRestClientService inventoryRestClientService
                            ){
        return args -> {
            List<Costumer> costumers=customerRestClientService.allCustomers().getContent().stream().toList();
            List<Product> products=inventoryRestClientService.allProducts().getContent().stream().toList();


            Long customerId=1L;

            Random random=new Random();

            Costumer costumer=customerRestClientService.CustomerById(customerId);

            for (int i = 0; i <20; i++) {
            Order order= Order.builder()
                    .customerId(costumers.get(random.nextInt(costumers.size())).getId())
                    .status(Math.random()>0.5?OrderStatus.PENDING:OrderStatus.CREATED)
                    .createdAt(new Date())
                    .build();
            Order saveOrder= orderRepository.save(order);

                for (int j = 0; j < products.size(); j++) {
                    if (Math.random() > 0.70) {
                        ProductItem productItem = ProductItem.builder()
                                .order(saveOrder)
                                .productId(products.get(j).getId())
                                .price(products.get(j).getPrice())
                                .quantity(1 + random.nextInt(10))
                                .discount(Math.random())
                                .build();
                        productItemRepository.save(productItem);
                    }
                }
            }

        };
    }

}
