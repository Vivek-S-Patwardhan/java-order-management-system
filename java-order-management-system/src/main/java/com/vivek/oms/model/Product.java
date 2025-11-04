package com.vivek.oms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setDescription(Object description2) {
		// TODO Auto-generated method stub
		
	}
	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}
	public Object getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setQuantity(Object quantity2) {
		// TODO Auto-generated method stub
		
	}
}
