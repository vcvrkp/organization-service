package com.tnt.organization;


import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages="com.tnt")
@RefreshScope
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class OrgserviceApplication {

    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Orgnization").select()
                .apis(RequestHandlerSelectors.basePackage("com.tnt"))
                .paths(any()).build().apiInfo(new ApiInfo("Organization Service",
                        "A set of services to provide data access to Organization and Departments", "1.0.0", null,
                        new Contact("Ramakrishna", "@Dell", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(OrgserviceApplication.class, args);
	}

}
