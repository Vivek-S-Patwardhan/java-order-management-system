package com.vivek.oms.controller;

import com.vivek.oms.dto.OrderRequest;
import com.vivek.oms.model.Order;
import com.vivek.oms.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService svc;
    public OrderController(OrderService svc){ this.svc = svc; }

    @GetMapping
    public List<Order> all(){ return svc.listAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id){
        Order o = svc.get(id);
        if(o==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderRequest req){
        Order created = svc.createOrder(req);
        return ResponseEntity.created(URI.create("/api/orders/"+created.getId())).body(created);
    }
}
