package com.example.product.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	private List<Product> list = new ArrayList<Product>();

	public List<Product> getAllProducts() {
		return list;
	}

	public Product getProductById(Long id) {
		return list.stream().filter(product -> id.equals(product.getId())).findAny().orElse(null);
	}

	public void addProduct(Product prod) {
		if (!list.isEmpty()) {
			Product lastProduct = list.get(list.size() - 1);
			prod.setId(lastProduct.getId() + 1);
		} else {
			prod.setId(1L);
		}
		prod.setCreatedOne(LocalDateTime.now());
		prod.setStatus(true);
		list.add(prod);
	}

	public void updateProduct(Product prod) {
		list.stream().filter(prodcut -> prod.getId().equals(prodcut.getId())).findFirst().ifPresent(productFound -> this.list.set(list.indexOf(productFound), prod));
		
	}

	public void removeProduct(Product prod) {
		list.remove(prod);
	}

	public void addList(List<Product> listOfProducts) {
		list.addAll(listOfProducts);
	}
}
