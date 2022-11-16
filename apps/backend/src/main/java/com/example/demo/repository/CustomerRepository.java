package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CustomerResponseDtoBody;
import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

  // https://www.baeldung.com/spring-data-jpa-query

  List<Customer> findByGender(String gender);

  @Query("SELECT c FROM Customer c WHERE c.gender = 'M'")
  List<Customer> findAllMaleCustomers();

  @Query("SELECT c FROM Customer c WHERE c.gender = :gender")
  List<Customer> findCustomerByGender(@Param("gender") String gender);

  @Query(value = "SELECT * FROM CUSTOMER c WHERE c.GENDER = 'M'", nativeQuery = true)
  List<Customer> findAllMaleCustomersNative();

  @Query(value = "SELECT * FROM CUSTOMER c WHERE c.GENDER = :gender", nativeQuery = true)
  List<Customer> findAllCustomersByGenderNative(@Param("gender") String gender);

  @Query(value = "SELECT c.CUSTOMER_ID as customerId, c.NAME as name FROM CUSTOMER c WHERE c.GENDER = :gender", nativeQuery = true)
  List<CustomerResponseDtoBody> findCustomerNameByGenderNative(@Param("gender") String gender);

}
