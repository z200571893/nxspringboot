package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeaderResponse;
import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponseDto;
import com.example.demo.dto.CustomerResponseDtoBody;
import com.example.demo.service.CustomerService;

@CrossOrigin
@RestController
public class Ch06Controller {

  @Autowired
  public CustomerService customerService;

  @PostMapping("/ch06")
  public CustomerResponseDto ch06(@RequestBody CustomerRequest request) {
    CustomerResponseDto response = new CustomerResponseDto();

    CommonHeaderResponse header = new CommonHeaderResponse();

    BeanUtils.copyProperties(request.getHeader(), header);

    String gender = request.getBody().getGender();
    List<CustomerResponseDtoBody> customers = this.customerService.findCustomerNameByGenderNative(gender);

    String tel = request.getBody().getTel();
    List<CustomerResponseDtoBody> customersTel = this.customerService.findCustomerNameByTelNative(tel);

    if (customers != null && !customers.isEmpty()) {

      header.setCode("0000");
      header.setMsg("成功");

      response.setBody(customers);
      response.setBody(customersTel);
    } else {
      header.setCode("9999");
      header.setMsg("查無資料");
    }

    response.setHeader(header);

    return response;
  }

  // 自定義
  @PostMapping("/ch06_Test")
  public CustomerResponseDto ch06_Test(@RequestBody CustomerRequest request) {
    CustomerResponseDto response = new CustomerResponseDto();

    CommonHeaderResponse header = new CommonHeaderResponse();

    BeanUtils.copyProperties(request.getHeader(), header);

    String gender = request.getBody().getGender();
    String tel = request.getBody().getTel();
    List<CustomerResponseDtoBody> customers = this.customerService.findCustomerNameByGenderNative(gender, tel);
    if (customers != null && !customers.isEmpty()) {

      header.setCode("0000");
      header.setMsg("成功");

      response.setBody(customers);
    } else {
      header.setCode("9999");
      header.setMsg("查無資料");
    }

    response.setHeader(header);

    return response;
  }
}
