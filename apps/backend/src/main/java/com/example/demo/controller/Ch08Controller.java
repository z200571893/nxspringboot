package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeaderResponse;
import com.example.demo.dto.CustomerRequestValid;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.dto.CustomerResponseBody;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin
@RestController
public class Ch08Controller {

  @Autowired
  public CustomerService customerService;

  @PostMapping("/ch08")
  public CustomerResponse ch08(@Valid @RequestBody CustomerRequestValid request, Errors errors) {
    CustomerResponse response = new CustomerResponse();

    CommonHeaderResponse header = new CommonHeaderResponse();
    BeanUtils.copyProperties(request.getHeader(), header);

    if (errors.hasErrors()) {
      header.setCode("9999");
      header.setMsg(errors.getFieldError().getDefaultMessage());
    } else {
      List<CustomerResponseBody> dataList = new LinkedList<>();

      String gender = request.getBody().getGender();
      List<Customer> customers = this.customerService.findCustomerByGenderStream(gender);

      if (customers != null && !customers.isEmpty()) {
        header.setCode("0000");
        header.setMsg("成功");

        for (Customer customer : customers) {
          CustomerResponseBody responseBody = new CustomerResponseBody();
          BeanUtils.copyProperties(customer, responseBody);
          dataList.add(responseBody);
        }

        response.setBody(dataList);
      } else {
        header.setCode("9999");
        header.setMsg("查無資料");
      }
    }

    response.setHeader(header);

    return response;
  }
}
