package com.pburgov.msscbrewery.web.controller;

import com.pburgov.msscbrewery.services.BeerService;
import com.pburgov.msscbrewery.web.model.BeerDto;
import java.sql.ResultSet;
import java.util.UUID;
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
@RequestMapping("/api/v1/beer")
public class BeerController {

  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK );
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
     BeerDto savedBeer = beerService.saveNewBeer(beerDto);
     HttpHeaders headers = new HttpHeaders();
     headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
     return new ResponseEntity(headers,HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity handlePut (@PathVariable("beerId") UUID beerId,  @RequestBody BeerDto beerDto){
      beerService.updateBeer(beerId, beerDto);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeerById(@PathVariable("beerId") UUID beerId){
    beerService.deleteBeerById(beerId);
  }
}
