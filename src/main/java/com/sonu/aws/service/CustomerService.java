package com.sonu.aws.service;

import com.sonu.aws.model.Customer;
import com.sonu.aws.model.CustomerRequest;
import com.sonu.aws.model.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public CustomerResponse getCustomer(String customerId);

    public List<Customer> getAllCustomers();

    public CustomerResponse addCustomer(CustomerRequest customerRequest);

    public CustomerResponse updateCustomer(CustomerRequest customerRequest);

    public String deleteCustomer(String customerId);
}
