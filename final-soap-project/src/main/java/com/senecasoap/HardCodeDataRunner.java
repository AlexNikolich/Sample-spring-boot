package com.senecasoap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.senecasoap.entity.Customer;
import com.senecasoap.entity.Product;
import com.senecasoap.entity.Sale;
import com.senecasoap.entity.SaleRep;
import com.senecasoap.entity.Time;
import com.senecasoap.service.SaleService;

@Component
public class HardCodeDataRunner implements CommandLineRunner {

	@Autowired
	private SaleService saleService;
	
	@Override
	public void run(String... args) throws Exception {

		Customer customer1 = new Customer();
		customer1.setFirstName("Alex");
		customer1.setLastName("Nikolic");
		customer1.setAddress1("Bloor 1");
		customer1.setAddress2("Bloor 2");
		customer1.setCity("Toronto");
		customer1.setState("Ontario");
		customer1.setZip("AAA AAA");
		customer1.setCountry("Canada");
		
		Customer customer2 = new Customer();
		customer2.setFirstName("Burl");
		customer2.setLastName("Packett");
		customer2.setAddress1("Bloor 10");
		customer2.setAddress2("Bloor 11");
		customer2.setCity("Toronto");
		customer2.setState("Ontario");
		customer2.setZip("BBB BBB");
		customer2.setCountry("Canada");
		
		Customer customer3 = new Customer();
		customer3.setFirstName("Diana");
		customer3.setLastName("Nikolic");
		customer3.setAddress1("Bloor 20");
		customer3.setAddress2("Bloor 21");
		customer3.setCity("Hamilton");
		customer3.setState("Ontario");
		customer3.setZip("CCC CCC");
		customer3.setCountry("Canada");
		
		Customer customer4 = new Customer();
		customer4.setFirstName("Mila");
		customer4.setLastName("Laplant");
		customer4.setAddress1("Bloor 30");
		customer4.setAddress2("Bloor 31");
		customer4.setCity("New York");
		customer4.setState("NY");
		customer4.setZip("DDD DDD");
		customer4.setCountry("USA");
		
		
		
		Product p1 = new Product();
		p1.setProductName("first");
		p1.setProductDescription("first product");
		p1.setUnitPrice(10.01);
		p1.setUnitCost(11.11);
		
		Product p2 = new Product();
		p2.setProductName("second");
		p2.setProductDescription("second product");
		p2.setUnitPrice(20.02);
		p2.setUnitCost(22.22);
		
		Product p3 = new Product();
		p3.setProductName("third");
		p3.setProductDescription("third product");
		p3.setUnitPrice(30.03);
		p3.setUnitCost(33.33);
		
		Product p4 = new Product();
		p4.setProductName("fourth");
		p4.setProductDescription("fourth product");
		p4.setUnitPrice(40.04);
		p4.setUnitCost(44.44);
		
		Product p5 = new Product();
		p5.setProductName("fifth");
		p5.setProductDescription("fifth product");
		p5.setUnitPrice(50.05);
		p5.setUnitCost(55.55);
		
		
		
		SaleRep saleRep1 = new SaleRep();
		saleRep1.setFirstName("Bob");
		saleRep1.setLastName("BobBob");
		saleRep1.setAddress1("Dundas 1");
		saleRep1.setAddress2("Dundas 2");
		saleRep1.setCity("Toronto");
		saleRep1.setState("Ontario");
		saleRep1.setZip("XXX XXX");
		saleRep1.setCountry("Canada");
		
		SaleRep saleRep2 = new SaleRep();
		saleRep2.setFirstName("Rob");
		saleRep2.setLastName("RobRob");
		saleRep2.setAddress1("Dundas 10");
		saleRep2.setAddress2("Dundas 11");
		saleRep2.setCity("Toronto");
		saleRep2.setState("Ontario");
		saleRep2.setZip("YYY YYY");
		saleRep2.setCountry("BRASIL");
		
		
		
		Time t1 = new Time();
		t1.setYear(2017);
		t1.setQuarter(3);
		t1.setMonth(05);
		t1.setWeek(1);
		
		Time t2 = new Time();
		t2.setYear(2018);
		t2.setQuarter(1);
		t2.setMonth(02);
		t2.setWeek(3);

		
		
		Sale s1 = new Sale();
		s1.setSaleAmount(100.10);
		s1.setCustomer(customer1);
		s1.setProduct(p1);
		s1.setSaleRep(saleRep1);
		s1.setTime(t1);
		
		Sale s2 = new Sale();
		s2.setSaleAmount(200.10);
		s2.setCustomer(customer2);
		s2.setProduct(p2);
		s2.setSaleRep(saleRep2);
		s2.setTime(t2);
		
		Sale s3 = new Sale();
		s3.setSaleAmount(300.10);
		s3.setCustomer(customer3);
		s3.setProduct(p3);
		s3.setSaleRep(saleRep2);
		s3.setTime(t2);
		
		Sale s4 = new Sale();
		s4.setSaleAmount(400.10);
		s4.setCustomer(customer4);
		s4.setProduct(p4);
		s4.setSaleRep(saleRep2);
		s4.setTime(t1);
		
		Sale s5 = new Sale();
		s5.setSaleAmount(500.10);
		s5.setCustomer(customer4);
		s5.setProduct(p5);
		s5.setSaleRep(saleRep1);
		s5.setTime(t2);
		
		Sale s6 = new Sale();
		s6.setSaleAmount(600.10);
		s6.setCustomer(customer2);
		s6.setProduct(p5);
		s6.setSaleRep(saleRep1);
		s6.setTime(t1);
		
		Sale s7 = new Sale();
		s7.setSaleAmount(700.10);
		s7.setCustomer(customer4);
		s7.setProduct(p4);
		s7.setSaleRep(saleRep1);
		s7.setTime(t2);
		
		Sale s8 = new Sale();
		s8.setSaleAmount(800.10);
		s8.setCustomer(customer3);
		s8.setProduct(p3);
		s8.setSaleRep(saleRep1);
		s8.setTime(t2);
		
		Sale s9 = new Sale();
		s9.setSaleAmount(900.10);
		s9.setCustomer(customer1);
		s9.setProduct(p1);
		s9.setSaleRep(saleRep1);
		s9.setTime(t1);
		
		Sale s10 = new Sale();
		s10.setSaleAmount(1000.10);
		s10.setCustomer(customer2);
		s10.setProduct(p2);
		s10.setSaleRep(saleRep2);
		s10.setTime(t1);
		
		

		
		List<Sale> saleList = new ArrayList<>();
		saleList.add(s1);
		saleList.add(s2);
		saleList.add(s3);
		saleList.add(s4);
		saleList.add(s5);
		saleList.add(s6);
		saleList.add(s7);
		saleList.add(s8);
		saleList.add(s9);
		saleList.add(s10);
		
		
		saleService.saveSale(saleList);
		
	}

	

}
