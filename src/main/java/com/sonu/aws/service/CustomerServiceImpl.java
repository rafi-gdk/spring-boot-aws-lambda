package com.sonu.aws.service;

import com.sonu.aws.exception.CustomerDataException;
import com.sonu.aws.model.Customer;
import com.sonu.aws.model.CustomerRequest;
import com.sonu.aws.model.CustomerResponse;
import com.sonu.aws.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sonu.aws.util.CustomerUtil.buildCustomerRequest;
import static com.sonu.aws.util.CustomerUtil.buildCustomerResponse;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public CustomerResponse getCustomer(String customerEmail) {
        CustomerResponse response;
        try {
            Optional<Customer> customer = repository.findByCustomerEmail(customerEmail);
            if (customer.isPresent()) {
                response = buildCustomerResponse(customer.get());
                log.info("getCustomer Response: {}", response);
            } else {
                throw new CustomerDataException("Customer Not Found");
            }
        } catch (Exception e) {
            log.error("Exception Occurred in getCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return response;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> response;
        try {
            response = repository.findAll();
            log.info("getAllCustomers Response: {}", response);
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            throw new CustomerDataException(e);
        }
        return response;
    }

    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        CustomerResponse response;

        try {
            Customer customer = repository.save(buildCustomerRequest(customerRequest));
            if (customer != null) {
                response = buildCustomerResponse(customer);
                log.info("addCustomer Response: {} ", response);
            } else {
                throw new CustomerDataException("Customer Insert Failed");
            }
        } catch (Exception e) {
            log.error("Exception Occurred in addCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return response;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
        CustomerResponse response;
        try {
            Optional<Customer> customer = repository.findByCustomerEmail(customerRequest.getCustomerEmail());
            if (customer.isPresent()) {
                Customer saveCustomer = repository.save(buildCustomerRequest(customerRequest));
                if (saveCustomer != null) {
                    response = buildCustomerResponse(saveCustomer);
                    log.info("updateCustomer Response: {}", response);
                } else {
                    throw new CustomerDataException("Customer Update Failed");
                }
            } else {
                throw new CustomerDataException("Customer Not found");
            }
        } catch (Exception e) {
            log.error("Exception Occurred in updateCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return response;
    }

    @Override
    public String deleteCustomer(String customerEmail) {
        try {
            repository.deleteByCustomerEmail(customerEmail);
            log.info("deleteCustomer Response: {}", customerEmail);
        } catch (Exception e) {
            log.error("Exception Occurred in deleteCustomer: " + e);
            throw new CustomerDataException(e);
        }
        return "success";
    }
}