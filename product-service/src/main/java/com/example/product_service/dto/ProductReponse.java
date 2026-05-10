package com.example.product_service.dto;

import java.math.BigDecimal;

public record ProductReponse(String id, String name, String description, BigDecimal price) {
}
