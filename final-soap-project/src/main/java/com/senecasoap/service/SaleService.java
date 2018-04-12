package com.senecasoap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senecasoap.entity.Sale;
import com.senecasoap.repository.SaleRepository;

@Service
public class SaleService{

	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> getSaleAll(){
		List<Sale> ls = saleRepository.findAll();
		return ls;
	}
	
	public void saveSale(List<Sale> sale){
		saleRepository.save(sale);
	}

	public List<Sale> findAllSales(String name, List<Sale> ls) {
		List<Sale> sales = new ArrayList<>();
		for (int i = 0; i < ls.size(); i++) {
			if(ls.get(i).getCustomer().getLastName().equals(name)){
				sales.add(ls.get(i));
			}
		}
		return sales;
	}
}
