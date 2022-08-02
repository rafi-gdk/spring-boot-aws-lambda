package com.sonu.aws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    String customerId;
    String customerName;
    LocalDate customerDOB;
    Long customerPhoneNumber;
    String customerEmail;
    String customerPassword;
}