package com.example.Challenge_4.model.request;

import com.example.Challenge_4.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String userId;
    private List<Product> products;
    private String shippingAddress;
    private String destination;
}
