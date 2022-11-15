package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeaderResponse;
import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.dto.CustomerResponseBody;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin
@RestController
public class Ch04Controller {

  @Autowired
  public CustomerService customerService;

  @PostMapping("/ch04")
  public CustomerResponse hello(@RequestBody CustomerRequest request) {
    CustomerResponse response = new CustomerResponse();
    CustomerResponseBody responseBody = new CustomerResponseBody();

    CommonHeaderResponse header = new CommonHeaderResponse();
    BeanUtils.copyProperties(request.getHeader(), header);

    String customerId = request.getBody().getCustomerId();
    Customer customer = this.customerService.findByCustomerId(customerId);

    if (customer != null) {
      header.setCode("0000");
      header.setMsg("成功");

      BeanUtils.copyProperties(customer, responseBody);
    } else {
      header.setCode("9999");
      header.setMsg("查無資料");
    }

    response.setHeader(header);
    response.setBody(responseBody);

    return response;
  }
}
