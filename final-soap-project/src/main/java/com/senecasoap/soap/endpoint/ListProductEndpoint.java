package com.senecasoap.soap.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.senecasoap.entity.Product;
import com.senecasoap.service.ProductService;
import com.senecasoap.soap.factory.ListProductRequest;
import com.senecasoap.soap.factory.ListProductResponse;
import com.senecasoap.soap.factory.ProductSoap;

@Endpoint
public class ListProductEndpoint {

	// to call wsdl http://localhost:8080/service/salesDetailsWsdl.wsdl

	private static final String NAMESPACE_URI = "http://www.senecasoap.com/soap/factory";


	@Autowired
	private ProductService productService;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ListProductRequest")
	@ResponsePayload
	public ListProductResponse getStudent(@RequestPayload ListProductRequest request) {

		ListProductResponse response = new ListProductResponse();

		String price = request.getPrice();
		String cost = request.getCost();
		
		if(!(price.equals("")) && !(cost.equals(""))){
			return response;
		}
		
		if (!(price == "")) {
			List<Product> lp1 = (List<Product>) productService.getProductAll();
			List<Product> lp = productService.findAllProductByPrice(price, lp1);

			for (int i = 0; i < lp.size(); i++) {
				ProductSoap ps = new ProductSoap();

				ps.setProductName(lp.get(i).getProductName());
				ps.setProductDescription(lp.get(i).getProductDescription());
				ps.setPrice(lp.get(i).getUnitPrice());
				ps.setCost(lp.get(i).getUnitCost());
				response.getProductSoap().add(i, ps);
			}
			if (!(lp.size() == 0)) {
				return response;
			}

		}

		if (!(cost == "")) {
			List<Product> lp1 = (List<Product>) productService.getProductAll();
			List<Product> lp = productService.findAllProductByCost(cost, lp1);
			
			for (int i = 0; i < lp.size(); i++) {
				ProductSoap ps = new ProductSoap();

				ps.setProductName(lp.get(i).getProductName());
				ps.setProductDescription(lp.get(i).getProductDescription());
				ps.setPrice(lp.get(i).getUnitPrice());
				ps.setCost(lp.get(i).getUnitCost());
				response.getProductSoap().add(i, ps);
			}
			if (!(lp.size() == 0)) {
				return response;
			}
		}
		return response;
	}
}
