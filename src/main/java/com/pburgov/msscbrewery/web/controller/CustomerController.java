package com.pburgov.msscbrewery.web.controller;

import com.pburgov.msscbrewery.services.CustomerService;
import com.pburgov.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity handlePost(@RequestBody CustomerDTO customerDto){
    CustomerDTO savedCustomer = customerService.saveNewCustomer(customerDto);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer/" + savedCustomer.getCustomerId().toString());
    return new ResponseEntity(headers,HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handlePut(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO){
    customerService.updateCustomer(customerId, customerDTO);
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
    customerService.deleteById(customerId);
  }




}
