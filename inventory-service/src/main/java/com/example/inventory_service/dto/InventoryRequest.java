package com.example.inventory_service.dto;

public record InventoryRequest(String skuCode, Integer quantity) {
}
