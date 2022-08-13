package com.example.demo.config;

import jakarta.xml.bind.annotation.XmlSchema;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        // reusing the application context in the messsage dispatcher servlet
        servlet.setApplicationContext(context);

        // set the tranformation location where our wsdl file
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/soapWS/*");
    }

    // Create a bean for loading the XML schenma
    @Bean
    public XsdSchema productSchema() {
        return new SimpleXsdSchema(new ClassPathResource("products.xsd"));
    }

    // add this wsdl definition to spring boot applications
    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema productSchema) {
        DefaultWsdl11Definition def = new DefaultWsdl11Definition();
        def.setSchema(productSchema);
        def.setLocationUri("/soapWS");
        def.setPortTypeName("ProductServicePort");
        def.setTargetNamespace("demo.example.com/soap");

        return def;
    }

}
