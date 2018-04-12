package com.senecasoap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senecasoap.entity.Customer;
import com.senecasoap.entity.Product;
import com.senecasoap.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductAll(){
		List<Product> lp = productRepository.findAll();
		return lp;
	}
	
	public List<Product> findAllProductByPrice(String price, List<Product> ls) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < ls.size(); i++) {
			String s1 = (ls.get(i).getUnitPrice().toString());
			if(s1.equals(price)){
				products.add(ls.get(i));
			}
			s1 = "";
		}
		return products;
	}
	
	public List<Product> findAllProductByCost(String cost, List<Product> ls) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < ls.size(); i++) {
			String s1 = (ls.get(i).getUnitCost().toString());
			if(s1.equals(cost)){
				products.add(ls.get(i));
			}
			s1 = "";
		}
		return products;
	}
	
	public void saveNewProduct(Product product){
		productRepository.save(product);
	}
	
	
}
