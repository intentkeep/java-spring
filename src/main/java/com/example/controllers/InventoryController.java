package com.example.controllers;

import com.example.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InventoryController {
  private final InventoryService inventoryService = new InventoryService();

  @PostMapping("/api/inventory/reserve")
  public ResponseEntity<Map<String, String>> reserve(@RequestBody Map<String, Object> body) {
    try {
      String sku = String.valueOf(body.get("sku"));
      int quantity = Integer.parseInt(String.valueOf(body.get("quantity")));
      String result = inventoryService.reserve(sku, quantity);
      return ResponseEntity.ok(Map.of("status", result));
    } catch (IllegalArgumentException error) {
      return ResponseEntity.unprocessableEntity().body(Map.of("error", error.getMessage()));
    }
  }
}
