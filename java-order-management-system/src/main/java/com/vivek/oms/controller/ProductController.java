package com.vivek.oms.controller;

import com.vivek.oms.model.Product;
import com.vivek.oms.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService svc;
    public ProductController(ProductService svc){ this.svc = svc; }

    @GetMapping
    public List<Product> all(){ return svc.listAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        Product p = svc.get(id);
        if(p==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p){
        Product created = svc.create(p);
        return ResponseEntity.created(URI.create("/api/products/"+created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p){
        Product updated = svc.update(id,p);
        if(updated==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
