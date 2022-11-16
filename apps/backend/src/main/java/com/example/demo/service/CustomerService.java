package com.example.demo.service;

import java.util.List;

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

  public List<Customer> findByGender(String gender) {
    return this.customerRepository.findByGender(gender);
  }

  public List<Customer> findAllMaleCustomers() {
    return this.customerRepository.findAllMaleCustomers();
  }

  public List<Customer> findCustomerByGender(String gender) {
    return this.customerRepository.findCustomerByGender(gender);
  }

  public List<Customer> findAllMaleCustomersNative() {
    return this.customerRepository.findAllMaleCustomersNative();
  }

  public List<Customer> findAllCustomersByGenderNative(String gender) {
    return this.customerRepository.findAllCustomersByGenderNative(gender);
  }
}
