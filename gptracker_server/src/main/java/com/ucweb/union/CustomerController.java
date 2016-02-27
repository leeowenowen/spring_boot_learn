package com.ucweb.union;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Configuration
@EnableAutoConfiguration
class CustomerController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> iterable = repository.findAll();
        iterable.forEach(customer -> {
            customers.add(customer);
        });
        return customers;
    }
}
