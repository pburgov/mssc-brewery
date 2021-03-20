package com.pburgov.msscbrewery.services;

import com.pburgov.msscbrewery.web.model.BeerDto;
import java.util.UUID;

public interface BeerService {

  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beerDto);

  void updateBeer(UUID beerId, BeerDto beerDto);

  void deleteBeerById(UUID beerId);
}
