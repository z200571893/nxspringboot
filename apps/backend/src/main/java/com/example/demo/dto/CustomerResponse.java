package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

  @JsonProperty("header")
  public CommonHeaderResponse header;

  @JsonProperty("body")
  public CustomerResponseBody body;
}
