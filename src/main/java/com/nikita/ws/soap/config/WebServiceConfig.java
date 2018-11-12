package com.nikita.ws.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

/**
 * <h1>WebServiceConfig</h1>
 * The Spring Configuration Class.
 * Here are implemented all beans that are controlled IoC container.
 * @author Nikita
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    /**
     * declare a ServletRegistration bean
     *
     * @param context the Spring application context
     * @return ServletRegistrationBean object
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    /**
     *
     * @param verificationSchemaCollection the collection of schemas
     * @return generated wsdl
     */
    @Bean(name = "verification")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection verificationSchemaCollection) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CodeVerificationPort");
        definition.setTargetNamespace("http://soap.ws.nikita.com/verification");
        definition.setLocationUri("/ws");
        definition.setSchemaCollection(verificationSchemaCollection);
        return definition;
    }

    /**
     *
     * @return the collection of schemas
     * @throws Exception no file exceptions or something else
     */
    @Bean
    public XsdSchemaCollection verificationSchemaCollection() throws Exception {
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(
                new ClassPathResource("schema/CodeVerificationOperations.xsd"));
        xsds.setInline(true);
        return xsds;
    }
}
