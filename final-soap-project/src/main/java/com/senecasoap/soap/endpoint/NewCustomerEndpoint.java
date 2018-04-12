package com.senecasoap.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.senecasoap.entity.Customer;
import com.senecasoap.service.CustomerService;
import com.senecasoap.soap.factory.NewCustomerRequest;
import com.senecasoap.soap.factory.NewCustomerResponse;

@Endpoint
public class NewCustomerEndpoint {
	
	// to call wsdl http://localhost:8080/service/salesDetailsWsdl.wsdl

		private static final String NAMESPACE_URI = "http://www.senecasoap.com/soap/factory";


		@Autowired
		private CustomerService customerService;
		
		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "NewCustomerRequest")
		@ResponsePayload
		public NewCustomerResponse newCustomer(@RequestPayload NewCustomerRequest request) {

			NewCustomerResponse response = new NewCustomerResponse();

			String firstName = request.getFirstName();
			String lastName = request.getLastName();
			String address1 = request.getAddress1();
			String address2 = request.getAddress2();
			String city = request.getCity();
			String state = request.getState();
			String zip = request.getZip();
			String country = request.getCountry();
			
			if(!(firstName.equals("")) && !(lastName.equals(""))){
				Customer cus = new Customer();
				cus.setFirstName(firstName);
				cus.setLastName(lastName);
				cus.setAddress1(address1);
				cus.setAddress2(address2);
				cus.setCity(city);
				cus.setState(state);
				cus.setZip(zip);
				cus.setCountry(country);
				customerService.saveNewCustomer(cus);
				
				response.setCreate("Customer with full name: " + firstName + " " + lastName + " has been created!");
				return response;
				
			}
			
			response.setCreate("Customer MUST have first and last name!!!");
			return response;
		}

}
