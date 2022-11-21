package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ch09Controller {

  @GetMapping("/ch09")
  public String ch09(Model model) {
    model.addAttribute("text", "Hello World!!");
    return "hello";

  }
}
