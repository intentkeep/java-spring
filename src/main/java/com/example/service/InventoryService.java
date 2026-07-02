package com.example.service;

public class InventoryService {
  public static final int MAX_RESERVATION_UNITS = 100;

  public String reserve(String sku, int quantity) {
    if (quantity <= 0 || quantity > MAX_RESERVATION_UNITS) {
      throw new IllegalArgumentException("INVALID_QUANTITY");
    }
    if (!sku.startsWith("SKU-")) {
      throw new IllegalArgumentException("UNKNOWN_SKU");
    }
    return "RESERVED:" + sku;
  }
}
