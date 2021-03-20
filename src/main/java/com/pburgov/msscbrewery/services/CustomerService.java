package com.pburgov.msscbrewery.services;

import com.pburgov.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;

public interface CustomerService {
  CustomerDTO getById(UUID customerId);

}
