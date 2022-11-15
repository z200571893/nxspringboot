package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CUSTOMER")
public class Customer {

  @Id
  @Column(name = "CUSTOMER_ID")
  public String customerId;

  public String name;

  public String tel;

  public String addr;

  public BigDecimal age;
}
