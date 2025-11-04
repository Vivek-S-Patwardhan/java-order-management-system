package com.vivek.oms.service;

import com.vivek.oms.dto.OrderRequest;
import com.vivek.oms.model.Order;
import com.vivek.oms.model.OrderItem;
import com.vivek.oms.model.Product;
import com.vivek.oms.repository.OrderRepository;
import com.vivek.oms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public List<Order> listAll() { return orderRepo.findAll(); }

    public Order createOrder(OrderRequest req) {
        Order order = new Order();
        order.setCustomerName(req.getCustomerName());
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = req.getItems().stream().map(it -> {
            Product p = productRepo.findById(it.getProductId()).orElseThrow(() -> new RuntimeException("Product not found: "+it.getProductId()));
            OrderItem oi = new OrderItem();
            oi.setProductId(p.getId());
            oi.setProductName(p.getName());
            oi.setPrice(p.getPrice());
            oi.setQuantity(it.getQuantity());
            if(p.getQuantity() != null) {
                int remaining = p.getQuantity() - it.getQuantity();
                p.setQuantity(Math.max(0, remaining));
                productRepo.save(p);
            }
            return oi;
        }).collect(Collectors.toList());

        order.setItems(items);
        return orderRepo.save(order);
    }

    public Order get(Long id) { return orderRepo.findById(id).orElse(null); }
}
