package com.vivek.oms;

import com.vivek.oms.model.Product;
import com.vivek.oms.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final ProductRepository repo;
    public DataInitializer(ProductRepository repo){ this.repo = repo; }

    @PostConstruct
    public void init(){
        repo.save(new Product(null,"Phone","Smartphone XYZ",150.0,50));
        repo.save(new Product(null,"T-Shirt","Cotton T-Shirt",20.0,200));
        repo.save(new Product(null,"Laptop","Laptop ABC",750.0,15));
    }
}
