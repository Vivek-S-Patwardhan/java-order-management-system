package com.vivek.oms.service;

import com.vivek.oms.model.Product;
import com.vivek.oms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }

    public List<Product> listAll() { return repo.findAll(); }
    public Product get(Long id) { return repo.findById(id).orElse(null); }
    public Product create(Product p) { return repo.save(p); }
    public Product update(Long id, Product p) {
        return repo.findById(id).map(existing -> {
            existing.setName(p.getName());
            existing.setDescription(p.getDescription());
            existing.setPrice(p.getPrice());
            existing.setQuantity(p.getQuantity());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
