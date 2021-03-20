package com.pburgov.msscbrewery.web.controller;

import com.pburgov.msscbrewery.services.CustomerService;
import com.pburgov.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getById(@PathVariable("customerId") UUID customerId){
    return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);


  }


}
