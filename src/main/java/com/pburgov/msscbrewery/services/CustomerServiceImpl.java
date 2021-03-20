package com.pburgov.msscbrewery.services;

import com.pburgov.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDTO getById(UUID customerId) {
    return CustomerDTO.builder()
        .customerId(customerId)
        .customerName("John Doe")
        .build();
  }
}
