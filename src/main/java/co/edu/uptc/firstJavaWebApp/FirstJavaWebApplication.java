package co.edu.uptc.firstJavaWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FirstJavaWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstJavaWebApplication.class, args);
    }
} 