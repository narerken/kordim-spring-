package com.era.kordim.controller;

import com.era.kordim.dto.CountryDto;
import com.era.kordim.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody CountryDto countryDto){
        countryService.addCountry(countryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable("id") Long id, @RequestBody CountryDto countryDto){
        countryService.updateCountry(id, countryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id){
        if(countryService.deleteCountry(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
