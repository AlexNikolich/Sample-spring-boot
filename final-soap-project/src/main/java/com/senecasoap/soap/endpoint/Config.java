package com.senecasoap.soap.endpoint;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class Config {

	// to call wsdl  http://localhost:8080/service/salesDetailsWsdl.wsdl

		@Bean
		public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
			MessageDispatcherServlet servlet = new MessageDispatcherServlet();
			servlet.setApplicationContext(applicationContext);
			servlet.setTransformWsdlLocations(true);
			return new ServletRegistrationBean(servlet, "/service/*");
		}

		@Bean(name = "salesDetailsWsdl")
		public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema saleSchema) {
			DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
			wsdl11Definition.setPortTypeName("salesDetailsPort");
			wsdl11Definition.setLocationUri("/service/sales-details");
			wsdl11Definition.setTargetNamespace("http://www.senecasoap.com/soap/factory");
			wsdl11Definition.setSchema(saleSchema);
			return wsdl11Definition;
		}

		@Bean
		public XsdSchema saleSchema() {
			return new SimpleXsdSchema(new ClassPathResource("sale.xsd"));
		}
	}
