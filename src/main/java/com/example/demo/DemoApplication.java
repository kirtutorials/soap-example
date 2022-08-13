package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 	1. create wsdl file (xml)
 * 	2. convert wsd file to soap java clases
 * 	3. implement the  soap java classes to serve you endpoint
 *
 * 	Step 1: add the wsdl dependency (wsdl - web service description language) [Similar to JSON]
 * 	Step 2: Create wsdl document using XSD model (Create a XSD file inside resources [default location is xsdfolder])
 * 	Step 3: Install jaxb/jaxws plugin in pom.xml
 * 	Step 4: Generate the soap classes using wsdl/xsd (products.xsd) file using jaxb plugin by running Maven clean and install command
 * 			- it will creates POJO classes for xsd file
 * 	Step 5:  Create a product service to use
 * 	Step 6: Create an endpoint to the product service
 * 	Step 7: We need to configure the webservice to tell the spring boot that we are initializing the webservices using config file
 * 			and @EnableWS @Configuration
 *
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
