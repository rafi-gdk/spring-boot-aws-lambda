package com.sonu.aws.util;

import com.sonu.aws.model.Customer;
import com.sonu.aws.model.CustomerRequest;
import com.sonu.aws.model.CustomerResponse;
import org.springframework.beans.BeanUtils;

public class CustomerUtil {

    public static Customer buildCustomerRequest(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        return customer;
    }

    public static CustomerResponse buildCustomerResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }
}
