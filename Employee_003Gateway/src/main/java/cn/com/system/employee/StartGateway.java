package cn.com.system.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cn.com.system.employee.config")
@EnableEurekaClient
public class StartGateway {
    public static void main(String[] args) {
        SpringApplication.run(StartGateway.class, args);
    }
}
