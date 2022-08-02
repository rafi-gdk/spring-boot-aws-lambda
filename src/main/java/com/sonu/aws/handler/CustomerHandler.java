package com.sonu.aws.handler;

import com.sonu.aws.model.Customer;
import com.sonu.aws.model.CustomerRequest;
import com.sonu.aws.model.CustomerResponse;
import com.sonu.aws.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class CustomerHandler {

    @Autowired
    CustomerService customerService;

    @Bean
    public Function<String, CustomerResponse> getCustomer() {
        return customerEmail -> customerService.getCustomer(customerEmail);
    }

    @Bean
    public Supplier<List<Customer>> getAllCustomers() {
        return () -> customerService.getAllCustomers();
    }

    @Bean
    public Function<CustomerRequest, CustomerResponse> addCustomer() {
        return customerRequest -> customerService.addCustomer(customerRequest);
    }

    @Bean
    public Function<CustomerRequest, CustomerResponse> updateCustomer() {
        return customerRequest -> customerService.updateCustomer(customerRequest);
    }

    @Bean
    public Function<String, String> deleteCustomer() {
        return (customerEmail) -> customerService.deleteCustomer(customerEmail);
    }
}
