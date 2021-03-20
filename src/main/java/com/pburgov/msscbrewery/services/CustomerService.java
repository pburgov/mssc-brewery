package com.pburgov.msscbrewery.services;

import com.pburgov.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;

public interface CustomerService {
  CustomerDTO getById(UUID customerId);

  CustomerDTO saveNewCustomer(CustomerDTO customerDto);

  void updateCustomer(UUID customerId, CustomerDTO customerDTO);

  void deleteById(UUID customerId);
}
