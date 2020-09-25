package cn.com.system.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StartEureka02 {
    public static void main(String[] args) {
        SpringApplication.run(StartEureka02.class, args);
    }
}
