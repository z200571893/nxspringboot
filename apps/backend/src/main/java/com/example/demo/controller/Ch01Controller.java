package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Ch01Controller {

  @GetMapping("/ch01")
  String ch01() {
    return "Hello World";
  }
}
