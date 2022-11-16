package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Customer")
@Table(name = "CUSTOMER")
public class Customer {

  @Id
  @Column(name = "CUSTOMER_ID")
  public String customerId;
  public String name;
  public String tel;
  public String addr;
  public String gender;
  public BigDecimal age;
}
