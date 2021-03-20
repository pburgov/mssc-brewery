package com.pburgov.msscbrewery.services;

import com.pburgov.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID())
        .beerName("Galaxy Cat")
        .beerStyle("Pale Ale")
        .build();
  }
}
