package az.unibank.springbootbookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringbootBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBookStoreApplication.class, args);
    }

}
