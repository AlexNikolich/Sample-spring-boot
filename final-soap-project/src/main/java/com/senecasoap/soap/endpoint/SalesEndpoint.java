package com.senecasoap.soap.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.senecasoap.entity.Sale;
import com.senecasoap.service.SaleService;
import com.senecasoap.soap.factory.CustomerSoap;
import com.senecasoap.soap.factory.ProductSoap;
import com.senecasoap.soap.factory.SaleSoap;
import com.senecasoap.soap.factory.SalesDetailsRequest;
import com.senecasoap.soap.factory.SalesDetailsResponse;
import com.senecasoap.soap.factory.SalesRepSoap;
import com.senecasoap.soap.factory.TimeSoap;

@Endpoint
public class SalesEndpoint {

	// to call wsdl http://localhost:8080/service/salesDetailsWsdl.wsdl

	private static final String NAMESPACE_URI = "http://www.senecasoap.com/soap/factory";

	@Autowired
	private SaleService saleService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SalesDetailsRequest")
	@ResponsePayload
	public SalesDetailsResponse getStudent(@RequestPayload SalesDetailsRequest request) {

		SalesDetailsResponse response = new SalesDetailsResponse();

		String lastName = request.getLastName();

		List<Sale> lp1 = (List<Sale>) saleService.getSaleAll();

		List<Sale> lp = saleService.findAllSales(lastName, lp1);

		for (int i = 0; i < lp.size(); i++) {
			SaleSoap s1 = new SaleSoap();
			CustomerSoap c1 = new CustomerSoap();
			ProductSoap p1 = new ProductSoap();
			SalesRepSoap sp1 = new SalesRepSoap();
			TimeSoap t1 = new TimeSoap();

			c1.setFirstName(lp.get(i).getCustomer().getFirstName());
			c1.setLastName(lp.get(i).getCustomer().getLastName());
			c1.setAdress1(lp.get(i).getCustomer().getAddress1());
			c1.setAdress2(lp.get(i).getCustomer().getAddress2());
			c1.setCity(lp.get(i).getCustomer().getCity());
			c1.setZip(lp.get(i).getCustomer().getZip());
			c1.setCountry(lp.get(i).getCustomer().getCountry());

			p1.setProductName(lp.get(i).getProduct().getProductName());
			p1.setProductDescription(lp.get(i).getProduct().getProductDescription());
			p1.setPrice(lp.get(i).getProduct().getUnitPrice());
			p1.setCost(lp.get(i).getProduct().getUnitCost());

			sp1.setFirstName(lp.get(i).getSaleRep().getFirstName());
			sp1.setLastName(lp.get(i).getSaleRep().getLastName());
			sp1.setAddress1(lp.get(i).getSaleRep().getAddress1());
			sp1.setCountry(lp.get(i).getSaleRep().getCountry());

			t1.setYear(lp.get(i).getTime().getYear());
			t1.setQuarter(lp.get(i).getTime().getQuarter());
			t1.setMonth(lp.get(i).getTime().getMonth());
			t1.setWeek(lp.get(i).getTime().getWeek());

			s1.setCustomer(c1);

			s1.setProduct(p1);

			s1.setSalesRep(sp1);

			s1.setTime(t1);

			s1.setSalesAmount(lp.get(i).getSaleAmount());

			response.getSale().add(i, s1);
		}
		return response;
	}

}
