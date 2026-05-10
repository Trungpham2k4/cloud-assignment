package com.example.order_service.service;

import com.example.order_service.client.InventoryClient;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.entity.Order;
import com.example.order_service.event.OrderPlacedEvent;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {

        boolean isProductInStock = inventoryClient.isStockAvailable(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNo(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setTotalPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);

            // Send message to Kafka topic
            OrderPlacedEvent event = new OrderPlacedEvent(orderRequest.skuCode(), orderRequest.userDetails().email());
            kafkaTemplate.send("order-placed", event);
            log.info("Send event {} to order-placed topic", event);
        }else{
            throw new RuntimeException("Product " + orderRequest.skuCode() + " is not in stock");
        }

    }
}
