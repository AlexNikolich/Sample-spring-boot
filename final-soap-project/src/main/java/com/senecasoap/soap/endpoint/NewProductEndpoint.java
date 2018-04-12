package com.senecasoap.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.senecasoap.entity.Product;
import com.senecasoap.service.ProductService;
import com.senecasoap.soap.factory.NewProductRequest;
import com.senecasoap.soap.factory.NewProductResponse;

@Endpoint
public class NewProductEndpoint {

	// to call wsdl http://localhost:8080/service/salesDetailsWsdl.wsdl

	private static final String NAMESPACE_URI = "http://www.senecasoap.com/soap/factory";


	@Autowired
	private ProductService productService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "NewProductRequest")
	@ResponsePayload
	public NewProductResponse newCustomer(@RequestPayload NewProductRequest request) {

		NewProductResponse response = new NewProductResponse();

		String productName = request.getProductName();
		String productDescription = request.getProductDescription();
		Double unitPrice = request.getUnitPrice();
		Double unitCost = request.getUnitCost();

		
		if(!(productName.equals(""))){
			Product product = new Product();
			product.setProductName(productName);
			product.setProductDescription(productDescription);
			product.setUnitPrice(unitPrice);
			product.setUnitCost(unitCost);
			productService.saveNewProduct(product);
			
			response.setCreate("Product with name:"+ productName + " has been created!!!");
			return response;
			
		}
		
		response.setCreate("Product MUST have name!!!");
		return response;
	}

}
