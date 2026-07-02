package com.example.service;

public class InventoryService {
  public static final int MAX_RESERVATION_UNITS = 100;

  public String reserve(String sku, int quantity) {
    if (!sku.startsWith("SKU-")) {
      throw new IllegalArgumentException("UNKNOWN_SKU");
    }
    return "RESERVED:" + sku;
  }
}
