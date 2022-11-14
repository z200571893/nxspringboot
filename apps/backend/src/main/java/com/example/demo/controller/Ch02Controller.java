package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Ch02Controller {

  @Value("${env.name}")
  private String envName;

  @GetMapping("/ch02")
  String hello() {
    return envName;
  }
}
