package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  public CustomerRepository customerRepository;

  public Customer findByCustomerId(String customerId) {
    var op = this.customerRepository.findById(customerId);
    return op.isPresent() ? op.get() : null;
  }
}
