package com.sonu.aws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    //in below lines we are using GeneratedValue & GenericGenerator to generate UUID as ID
    //if you manually want to add then you can remove GeneratedValue & GenericGenerator
    @Id
    @GeneratedValue(generator = "gen_uuid")
    @GenericGenerator(name = "gen_uuid", strategy = "uuid2")
    @Column(name = "CUSTOMER_ID")
    String customerId;
    @Column(name = "CUSTOMER_NAME")
    String customerName;
    @Column(name = "CUSTOMER_DOB")
    LocalDate customerDOB;
    @Column(name = "CUSTOMER_PHONE_NUMBER")
    Long customerPhoneNumber;
    @Column(name = "CUSTOMER_EMAIL", unique = true)
    String customerEmail;
    @Column(name = "CUSTOMER_PASSWORD")
    String customerPassword;
}
