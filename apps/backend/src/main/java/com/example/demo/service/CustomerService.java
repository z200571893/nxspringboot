package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerResponseDtoBody;
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

  // +tel
  public List<CustomerResponseDtoBody> findCustomerNameByTelNative(String tel) {
    return this.customerRepository.findAllCustomerNameByTelNative(tel);
  }

  public List<CustomerResponseDtoBody> findCustomerNameByGenderNative(String gender) {
    return this.customerRepository.findCustomerNameByGenderNative(gender);
  }

  // 自定義
  public List<CustomerResponseDtoBody> findCustomerNameByGenderNative(String gender, String tel) {
    return this.customerRepository.findCustomerNameByGenderNative(gender, tel);
  }

  // +tel
  public List<Customer> findCustomerByTelStream(String tel) {
    var customers = this.customerRepository.findAll();
    return customers.stream().filter(x -> tel.equals(x.getTel())).toList();
  }

  public List<Customer> findCustomerByGenderStream(String gender) {
    var customers = this.customerRepository.findAll();
    // 一定要會用 stream抓資料
    return customers.stream().filter(o -> gender.equals(o.getGender())).toList();
  }
}
