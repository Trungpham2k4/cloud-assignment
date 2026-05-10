package com.example.order_service.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {

    Logger log = LoggerFactory.getLogger(InventoryClient.class);

    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isStockAvailable(@RequestParam String skuCode, @RequestParam Integer quantity);

    /**
     * Fallback method cần match với các parameters trên hàm gọi fallback (Ex: isStockAvailable)
     * */
    default boolean fallbackMethod(String skuCode, Integer quantity, Throwable throwable) {
        log.info("Cannot get inventory for skucode {}, failure reason: {}", skuCode, throwable.getMessage());
        return false;
    }
}
